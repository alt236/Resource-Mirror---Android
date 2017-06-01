/*
 * Copyright 2015 Alexandros Schillings
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.alt236.resourcemirror.reflectors.base;

import android.content.res.Resources;
import android.util.Log;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import uk.co.alt236.resourcemirror.containers.LruLinkedHashMap;

public abstract class AbstractResourceReflector implements ResourceReflector {
    private static final boolean TIME_LOGGING_ENABLED = false;
    private static final int CACHE_SIZE = 100;
    protected final ResourceKeyFormatter mKeyFormatter;
    private final AtomicBoolean mLogErrors;
    private final ReflectionCore mReflectionCore;
    private final Map<String, Integer> mCache;
    private final Set<String> mCacheMisses;

    protected AbstractResourceReflector(final String packageName) {
        mReflectionCore = new ReflectionCore(packageName);
        mKeyFormatter = new ResourceKeyFormatter();
        mCache = new LruLinkedHashMap<>(CACHE_SIZE, 0.75f);
        mCacheMisses = new HashSet<>(CACHE_SIZE, 0.75f);
        mLogErrors = new AtomicBoolean(false);
    }

    private void addToCache(final String key, final Integer value) {
        mCache.put(key, value);
    }

    private synchronized int fetchResourceId(final String resourceName, final int fallbackResourceId) {
        Integer result;
        final long startTime = System.nanoTime();

        // Check if its in the known "cache miss" list
        if (mCacheMisses.contains(resourceName)) {
            result = fallbackResourceId;
        } else {
            result = getFromCache(resourceName);

            if (result == null) {
                result = getReflectionCore().reflectResource(
                        getResourceType(),
                        resourceName,
                        fallbackResourceId,
                        isErrorLoggingEnabled());

                if (result != fallbackResourceId) {
                    addToCache(resourceName, result);
                } else {
                    // We do not have this drawable, add it in the "miss" cache.
                    mCacheMisses.add(resourceName);
                }
            }
        }

        if (TIME_LOGGING_ENABLED) {
            final long endTime = System.nanoTime();
            Log.d(getLogTag(), "fetchResourceId() - Fetched '" + resourceName + "' in " + (endTime - startTime) + "ns");
        }

        return result;
    }

    public List<String> getAllResourceTypes() {
        return mReflectionCore.getResourceTypes();
    }

    protected Integer getFromCache(final String key) {
        return mCache.get(key);
    }

    protected abstract String getLogTag();

    protected ReflectionCore getReflectionCore() {
        return mReflectionCore;
    }

    @Override
    public int getResourceId(final String resourceName) {
        return getResourceId(resourceName, null);
    }

    @Override
    public int getResourceId(final String resourceName, final String family) {
        final int resourceId = optResourceId(resourceName, family, -1);
        if (resourceId == -1) {
            throw new Resources.NotFoundException(mKeyFormatter.formatKey(resourceName, family));
        } else {
            return resourceId;
        }
    }

    @Override
    public List<String> getResourceList() {
        return mReflectionCore.getResourceList(getResourceType());
    }

    public boolean isErrorLoggingEnabled() {
        return mLogErrors.get();
    }

    @Override
    public int optResourceId(final String resourceName, final int fallbackResourceId) {
        return optResourceId(resourceName, null, fallbackResourceId);
    }

    @Override
    public int optResourceId(final String resourceName, final String family, final int fallbackResourceId) {
        return fetchResourceId(mKeyFormatter.formatKey(resourceName, family), fallbackResourceId);
    }

    /**
     * This function will print a list of all the resources of the current type
     * this library can see into logcat Only useful for debugging.
     */
    public void printResourcesToLogCat() {
        getReflectionCore().logFields(getResourceType());
    }

    /**
     * Enables or disables the logging of errors in LogCat during operation. The
     * errors will be logged as warning. Types of errors logged: - Reflection
     * Errors - Color parsing errors
     *
     * @param enable - True to enable, false to disable. False by default;
     */
    public void setLogErrors(final boolean enable) {
        mLogErrors.set(enable);
    }
}
