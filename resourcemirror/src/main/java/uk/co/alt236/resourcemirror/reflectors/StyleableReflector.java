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

package uk.co.alt236.resourcemirror.reflectors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;

import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirror.reflectors.base.AbstractResourceReflector;

public final class StyleableReflector extends AbstractResourceReflector {
    private static final ResourceType RESOURCE_TYPE = ResourceType.STYLEABLE;
    private final String TAG = getClass().getSimpleName();

    protected StyleableReflector(final String packageName) {
        super(packageName);
    }

    @NonNull
    @Override
    protected String getLogTag() {
        return TAG;
    }

    @NonNull
    @Override
    public ResourceType getResourceType() {
        return RESOURCE_TYPE;
    }

    @StyleableRes
    @Override
    public int getResourceId(@NonNull final String resourceName) {
        return super.getResourceId(resourceName);
    }

    @StyleableRes
    @Override
    public int getResourceId(@NonNull final String resourceName, final String family) {
        return super.getResourceId(resourceName, family);
    }

    @StyleableRes
    @Override
    public int optResourceId(@NonNull final String resourceName,
                             @StyleableRes final int fallbackResourceId) {
        return super.optResourceId(resourceName, fallbackResourceId);
    }

    @StyleableRes
    @Override
    public int optResourceId(@NonNull final String resourceName,
                             @Nullable final String family,
                             @StyleableRes final int fallbackResourceId) {
        return super.optResourceId(resourceName, family, fallbackResourceId);
    }
}
