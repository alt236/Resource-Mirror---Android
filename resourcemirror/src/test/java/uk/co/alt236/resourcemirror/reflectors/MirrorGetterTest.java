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
import uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector;
import uk.co.alt236.resourcemirror.testing.BaseRobolectricTest;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class MirrorGetterTest extends BaseRobolectricTest {
    private static final String PACKAGE_NAME = "fake_package_name";

    private Context mockContext;

    @Before
    public void setUp() {
        Mirror.clear();
        mockContext = Mockito.mock(Context.class);
        final Application mockApp = Mockito.mock(Application.class);
        Mockito.when(mockContext.getPackageName()).thenReturn(PACKAGE_NAME);
        Mockito.when(mockApp.getPackageName()).thenReturn(PACKAGE_NAME);
        Mockito.when(mockContext.getApplicationContext()).thenReturn(mockApp);
    }

    @Test
    public void testGetAnimations() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ANIM;
        final ResourceReflector reflector = Mirror.of(mockContext).getAnimations();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetAnimators() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ANIMATOR;
        final ResourceReflector reflector = Mirror.of(mockContext).getAnimators();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetArrays() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ARRAY;
        final ResourceReflector reflector = Mirror.of(mockContext).getArrays();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetAttrs() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ATTR;
        final ResourceReflector reflector = Mirror.of(mockContext).getAttrs();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetBooleans() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.BOOL;
        final ResourceReflector reflector = Mirror.of(mockContext).getBooleans();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetColors() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.COLOR;
        final ResourceReflector reflector = Mirror.of(mockContext).getColors();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetDimens() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.DIMEN;
        final ResourceReflector reflector = Mirror.of(mockContext).getDimens();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetDrawables() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.DRAWABLE;
        final ResourceReflector reflector = Mirror.of(mockContext).getDrawables();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetFractions() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.FRACTION;
        final ResourceReflector reflector = Mirror.of(mockContext).getFractions();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(mockContext).get(type));
    }

    @Test
    public void testGetIds() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ID;
        final ResourceReflector reflector = Mirror.of(mockContext).getIds();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetIntegers() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.INTEGER;
        final ResourceReflector reflector = Mirror.of(mockContext).getIntegers();
        commonComparisons(type, reflector);
    }

    public void testGetInterpolators() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.INTERPOLATOR;
        final ResourceReflector reflector = Mirror.of(mockContext).getInterpolators();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetLayouts() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.LAYOUT;
        final ResourceReflector reflector = Mirror.of(mockContext).getLayouts();
        commonComparisons(type, reflector);
    }

    public void testGetMenus() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.MENU;
        final ResourceReflector reflector = Mirror.of(mockContext).getMenus();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetMipMaps() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.MIPMAP;
        final ResourceReflector reflector = Mirror.of(mockContext).getMipMaps();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetPlurals() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.PLURALS;
        final ResourceReflector reflector = Mirror.of(mockContext).getPlurals();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetRaws() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.RAW;
        final ResourceReflector reflector = Mirror.of(mockContext).getRaws();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetStrings() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.STRING;
        final ResourceReflector reflector = Mirror.of(mockContext).getStrings();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetStyleables() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.STYLEABLE;
        final ResourceReflector reflector = Mirror.of(mockContext).getStyleables();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetStyles() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.STYLE;
        final ResourceReflector reflector = Mirror.of(mockContext).getStyles();
        commonComparisons(type, reflector);
    }

    @Test
    public void testGetXmls() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.XML;
        final ResourceReflector reflector = Mirror.of(mockContext).getXmls();
        commonComparisons(type, reflector);
    }

    private void commonComparisons(final ResourceType type,
                                   final ResourceReflector reflector) {
        assertNotNull(reflector);
        assertSame(type, reflector.getResourceType());
        assertSame(reflector, Mirror.of(mockContext).get(type));
    }
}