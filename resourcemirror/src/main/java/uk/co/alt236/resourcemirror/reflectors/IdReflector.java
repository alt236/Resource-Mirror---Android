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

import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirror.reflectors.base.AbstractResourceReflector;

public final class IdReflector extends AbstractResourceReflector {
    private static final ResourceType RESOURCE_TYPE = ResourceType.ID;
    private final String TAG = getClass().getSimpleName();

    protected IdReflector(final String packageName) {
        super(packageName);
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    public ResourceType getResourceType() {
        return RESOURCE_TYPE;
    }
}
