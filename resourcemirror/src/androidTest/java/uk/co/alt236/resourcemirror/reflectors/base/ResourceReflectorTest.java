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

import android.content.Context;
import android.content.res.Resources;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirror.ResourceType;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class ResourceReflectorTest {
    private static final String NON_EXISTING_RESOURCE = "!THIS_CANNOT_BE!";
    private static final String NON_EXISTING_FAMILY = "!THIS_CANNOT_BE!";

    private static final int FALLBACK_RES = 255;

    @Before
    public void setUp(){
        Mirror.clear();
    }

    @Test(expected = Resources.NotFoundException.class)
    public void testGetResourceId() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        Mirror.of(getContext()).getDimens().getResourceId(NON_EXISTING_RESOURCE);
    }

    public void testGetResourceId1() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        assertEquals(0, Mirror.getNumberOfMirrors());
        Mirror.of(getContext()).getDimens().getResourceId(NON_EXISTING_RESOURCE, NON_EXISTING_FAMILY);
    }

    public void testGetResourceType() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());

        for(final ResourceType type : ResourceType.values()){
            assertNotNull(Mirror.of(getContext()).get(type));
            assertEquals(type, Mirror.of(getContext()).get(type).getResourceType());
        }
    }

    public void testOptResourceId() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());

        for(final ResourceType type : ResourceType.values()){
            assertEquals(FALLBACK_RES, Mirror.of(getContext()).get(type).optResourceId(NON_EXISTING_RESOURCE, FALLBACK_RES));
        }
    }

    public void testOptResourceId1() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());

        for(final ResourceType type : ResourceType.values()){
            assertEquals(FALLBACK_RES, Mirror.of(getContext()).get(type).optResourceId(NON_EXISTING_RESOURCE, NON_EXISTING_FAMILY, FALLBACK_RES));
        }
    }

    private Context getContext() {
        return InstrumentationRegistry.getTargetContext();
    }
}