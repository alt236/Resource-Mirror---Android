package uk.co.alt236.resourcemirror.reflectors.base;

import android.content.res.Resources;
import android.util.Log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import uk.co.alt236.resourcemirror.containers.LruLinkedHashMap;
import uk.co.alt236.resourcemirror.util.ReflectionUtils;

public abstract class AbstractResourceReflector implements ResourceReflector {
	protected static final String THE_DEFAULT_CONSTRUCTOR_WAS_CALLED = "The default Constructor was called! This should never happen...";
	protected static final boolean TIME_LOGGING_ENABLED = false;
	protected static final int CACHE_SIZE = 100;

	private final AtomicBoolean mLogErrors;
	private final ReflectionUtils mReflectionUtils;
	private final Map<String, Integer> mCache;
	private final Map<String, Object> mCacheMisses;
    protected final ResourceKeyFormatter mKeyFormatter;

	protected AbstractResourceReflector(String packageName) {
		if (packageName == null) {
			mReflectionUtils = null;
		} else {
			mReflectionUtils = new ReflectionUtils(packageName);
		}
        mKeyFormatter = new ResourceKeyFormatter();
		mCache = new LruLinkedHashMap<String, Integer>(CACHE_SIZE, 0.75f);
		mCacheMisses = new LruLinkedHashMap<String, Object>(CACHE_SIZE, 0.75f);
		mLogErrors = new AtomicBoolean(false);
	}

	private void addToCache(String key, Integer value) {
		mCache.put(key, value);
	}

	private void addToMissCache(String key, Integer value) {
		mCacheMisses.put(key, value);
	}

	private synchronized int fetchResourceId(final String resourceName, final int fallbackResourceId) {
		Integer result;
		final long startTime;

		if (TIME_LOGGING_ENABLED) {
			startTime = System.nanoTime();
		}

		// Check if its in the known "cache miss" list
		if (isKeyInMisses(resourceName)) {
			result = fallbackResourceId;
		} else {
			result = getFromCache(resourceName);

			if (result == null) {
				result = getReflectionUtils().reflectResource(
						getResourceType(),
						resourceName,
						fallbackResourceId,
						isErrorLoggingEnabled());

				if (result != null && result != fallbackResourceId) {
					addToCache(resourceName, result);
				} else {
					// We do not have this drawable, add it in the "miss" cache.
					addToMissCache(resourceName, null);
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
		return mReflectionUtils.getResourceTypes();
	}

	protected Integer getFromCache(String key) {
		return mCache.get(key);
	}

	protected abstract String getLogTag();

	protected ReflectionUtils getReflectionUtils() {
		return mReflectionUtils;
	}

	@Override
	public int getResourceId(String resourceName) {
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
		return mReflectionUtils.getResourceList(getResourceType());
	}

	public boolean isErrorLoggingEnabled() {
		return mLogErrors.get();
	}

	private boolean isKeyInMisses(final String key) {
		return mCacheMisses.containsKey(key);
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
		getReflectionUtils().logFields(getResourceType());
	}

	/**
	 * Enables or disables the logging of errors in LogCat during operation. The
	 * errors will be logged as warning. Types of errors logged: - Reflection
	 * Errors - Color parsing errors
	 *
	 * @param enable
	 *            - True to enable, false to disable. False by default;
	 */
	public void setLogErrors(boolean enable) {
		mLogErrors.set(enable);
	}
}
