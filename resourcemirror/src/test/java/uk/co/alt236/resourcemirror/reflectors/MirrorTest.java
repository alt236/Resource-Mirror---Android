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


import android.app.Application;
import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirror.testing.BaseRobolectricTest;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MirrorTest extends BaseRobolectricTest {
    private static final String PACKAGE_NAME = "fake_package_name";

    private Context mockContext;

    @Before
    public void setUp(){
        Mirror.clear();
        mockContext = Mockito.mock(Context.class);
        final Application mockApp = Mockito.mock(Application.class);
        Mockito.when(mockContext.getPackageName()).thenReturn(PACKAGE_NAME);
        Mockito.when(mockApp.getPackageName()).thenReturn(PACKAGE_NAME);
        Mockito.when(mockContext.getApplicationContext()).thenReturn(mockApp);
    }

    @Test
    public void testGet() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());

        for(final ResourceType type : ResourceType.values()){
            assertNotNull(Mirror.of(mockContext).get(type));
            assertEquals(type, Mirror.of(mockContext).get(type).getResourceType());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetNull() {
        Mirror.of(mockContext).get(null);
    }

    @Test
    public void testGetPackageNameAfterSetup() {
        assertEquals(0, Mirror.getNumberOfMirrors());
        Mirror.of(mockContext).getAnimations();
        assertEquals(1, Mirror.getNumberOfMirrors());
        assertEquals(PACKAGE_NAME, Mirror.of(mockContext).getPackageName());
    }

    @Test
    public void testGetPackageNameUtil() {
        assertEquals(0, Mirror.getNumberOfMirrors());
        assertEquals(PACKAGE_NAME, Mirror.getPackageName(mockContext));
        assertEquals(0, Mirror.getNumberOfMirrors());
    }
}