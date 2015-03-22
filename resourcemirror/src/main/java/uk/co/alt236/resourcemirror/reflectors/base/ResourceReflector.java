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

import java.util.List;

import uk.co.alt236.resourcemirror.util.ResourceType;

public interface ResourceReflector {

    /**
     * Attempts to retrieve the Id of the requested Resource.
     *
     * @param resourceName The name of the Resource to fetch.
     * @return The id of the Resource corresponding to the passed parameters.
     * @throws android.content.res.Resources.NotFoundException if the requested resource was not found.
     */
    public int getResourceId(String resourceName);

    /**
     * Attempts to retrieve the Id of the requested Resource.
     *
     * @param resourceName       The name of the Resource to fetch.
     * @param fallbackResourceId The id of the Resource to use if the requested one does not exist.
     *                           It has to be of the same type as the requested Resource
     * @return The id of the Resource corresponding to the passed parameters.
     */
    public int optResourceId(String resourceName, int fallbackResourceId);

    /**
     * Attempts to retrieve the Id of the requested Resource.
     *
     * @param resourceName The name of the Resource to fetch.
     * @param family       The family (if any) of the variable to fetch. Set to null if no family is needed.
     * @return The id of the Resource corresponding to the passed parameters.
     * @throws android.content.res.Resources.NotFoundException if the requested resource was not found.
     */
    public int getResourceId(String resourceName, String family);

    /**
     * Attempts to retrieve the Id of the requested Resource.
     *
     * @param resourceName       The name of the Resource to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if no family is needed.
     * @param fallbackResourceId The id of the Resource to use if the requested one does not exist.
     *                           It has to be of the same type as the requested Resource
     * @return The id of the Resource corresponding to the passed parameters.
     */
    public int optResourceId(String resourceName, String family, int fallbackResourceId);

    public ResourceType getResourceType();

    public List<String> getResourceList();
}
