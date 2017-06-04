package uk.co.alt236.resourcemirror;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ResourceTypeTest {

    @Test
    public void testFromString() {
        for (final ResourceType value : ResourceType.values()) {
            assertEquals("For " + value, value, ResourceType.fromString(value.getResourceName()));
        }
    }

    @Test
    public void testFromStringInvalid() {
        String value = null;
        assertNull("For " + value, ResourceType.fromString(value));

        value = "foo";
        assertNull("For " + value, ResourceType.fromString(value));

        value = "";
        assertNull("For " + value, ResourceType.fromString(value));
    }
}