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

import android.util.Log;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.alt236.resourcemirror.ResourceType;

/*package*/ class ReflectionCore {
    private final String TAG = getClass().getSimpleName();
    private final String mPackageName;
    private final Map<String, Class<?>> mClassCache;

    public ReflectionCore(final String appPackageName) {
        mPackageName = appPackageName;
        mClassCache = new HashMap<>();
    }

    private Class<?> getResourceClass(final String suffix) {
        if (mClassCache.containsKey(suffix)) {
            return mClassCache.get(suffix);
        } else {
            try {
                final Class<?> rClassBase = Class.forName(mPackageName + ".R");
                final Class<?>[] subClassTable = rClassBase.getDeclaredClasses();

                for (final Class<?> subClass : subClassTable) {
                    if (subClass.getCanonicalName().endsWith(suffix)) {
                        mClassCache.put(suffix, subClass);
                        return subClass;
                    }
                }

            } catch (final ClassNotFoundException e) {
                Log.e(TAG, "getResourceClass() ClassNotFoundException: " + e.getMessage(), e);
            }

            Log.e(TAG, "getResourceClass() Unable to find Sublass: " + suffix);

            return null;
        }
    }

    public List<String> getResourceList(final ResourceType type) {
        final List<String> list = new ArrayList<>();
        final Class<?> resourceClass = getResourceClass(getResourceLocation(type));

        if (resourceClass != null) {
            final Field[] resourceArray = resourceClass.getFields();

            for (final Field field : resourceArray) {
                try {
                    if (int.class.equals(field.getType())) {
                        list.add(field.getName());
                    }
                } catch (final IllegalArgumentException e) {
                    Log.e(TAG, "getResourceList() Error: " + e.getMessage(), e);
                }
            }
        }

        Collections.sort(list);
        return Collections.unmodifiableList(list);
    }

    public List<String> getResourceTypes() {
        final String baseClass = mPackageName + ".R";
        final List<String> list = new ArrayList<>();

        Log.d(TAG, "getResourceClass() Getting for '" + baseClass + "' ============= ");
        try {
            final Class<?> rClassBase = Class.forName(baseClass);
            final Class<?>[] subClassTable = rClassBase.getDeclaredClasses();

            for (final Class<?> subClass : subClassTable) {
                Log.d(TAG, "getResourceClass() Name: " + subClass.getName());
                list.add(subClass.getSimpleName());
            }

        } catch (final ClassNotFoundException e) {
            Log.e(TAG, "getResourceClass() ClassNotFoundException: " + e.getMessage(), e);
        }

        return list;
    }

    public void logFields(final ResourceType type) {
        final String resourceLocation = getResourceLocation(type);

        Log.d(TAG, "logFields() Getting Fields for '" + resourceLocation + "' ============= ");

        try {
            final Field[] fields = getResourceClass(resourceLocation).getFields();

            for (final Field field : fields) {
                Log.d(TAG, "logFields() Field: '" + field.getName() + "'");

            }
        } catch (final NullPointerException e) {
        }
    }

    public int reflectResource(final ResourceType type, final String fieldName, final int defaultValue, final boolean reportFailure) {
        final String resourceLocation = getResourceLocation(type);

        final int error;
        try {
            final Field field = getResourceClass(resourceLocation).getField(fieldName);
            if (field.getType().equals(int.class)) {
                return field.getInt(null);
            } else {
                Log.w(TAG, String.format(
                        "reflectResource() Error getting resource Id for item '" + fieldName + "'. It is not of type int: Type = '%s'",
                        field.getGenericType().toString()));
                return defaultValue;
            }

        } catch (final NoSuchFieldException e) {
            error = 1;
        } catch (final IllegalAccessException e) {
            error = 2;
        } catch (final NullPointerException e) {
            error = 3;
        }

        if (reportFailure) {
            Log.w(TAG, "reflectResource() Resource '" + fieldName + "' not available! (" + error + ")");
        }

        return defaultValue;
    }

    private static String getResourceLocation(final ResourceType type) {
        return ".R." + type.getResourceName();
    }
}
