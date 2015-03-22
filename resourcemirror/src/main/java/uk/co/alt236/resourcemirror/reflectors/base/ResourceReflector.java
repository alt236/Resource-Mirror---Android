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
