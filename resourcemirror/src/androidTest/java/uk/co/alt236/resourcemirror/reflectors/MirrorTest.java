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

import android.test.AndroidTestCase;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector;

public class MirrorTest extends AndroidTestCase {

    @Override
    public void setUp(){
        Mirror.clear();
    }

    public void testGet() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());

        for(final ResourceType type : ResourceType.values()){
            assertNotNull(Mirror.of(getContext()).get(type));
            assertEquals(type, Mirror.of(getContext()).get(type).getResourceType());
        }


        try{
            Mirror.of(getContext()).get(null);
            fail("Should have thrown an exception...");
        } catch(final IllegalArgumentException e){
            // Expected
        }
    }

    public void testGetAnimations() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ANIM;
        final ResourceReflector reflector = Mirror.of(getContext()).getAnimations();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetAnimators() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ANIMATOR;
        final ResourceReflector reflector = Mirror.of(getContext()).getAnimators();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetArrays() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ARRAY;
        final ResourceReflector reflector = Mirror.of(getContext()).getArrays();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetAttrs() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ATTR;
        final ResourceReflector reflector = Mirror.of(getContext()).getAttrs();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetBooleans() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.BOOL;
        final ResourceReflector reflector = Mirror.of(getContext()).getBooleans();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetColors() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.COLOR;
        final ResourceReflector reflector = Mirror.of(getContext()).getColors();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetDimens() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.DIMEN;
        final ResourceReflector reflector = Mirror.of(getContext()).getDimens();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetDrawables() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.DRAWABLE;
        final ResourceReflector reflector = Mirror.of(getContext()).getDrawables();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetFractions() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.FRACTION;
        final ResourceReflector reflector = Mirror.of(getContext()).getFractions();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetIds() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.ID;
        final ResourceReflector reflector = Mirror.of(getContext()).getIds();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetIntegers() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.INTEGER;
        final ResourceReflector reflector = Mirror.of(getContext()).getIntegers();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetInterpolators() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.INTERPOLATOR;
        final ResourceReflector reflector = Mirror.of(getContext()).getInterpolators();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetLayouts() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.LAYOUT;
        final ResourceReflector reflector = Mirror.of(getContext()).getLayouts();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetMenus() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.MENU;
        final ResourceReflector reflector = Mirror.of(getContext()).getMenus();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetMipMaps() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.MIPMAP;
        final ResourceReflector reflector = Mirror.of(getContext()).getMipMaps();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetPlurals() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.PLURALS;
        final ResourceReflector reflector = Mirror.of(getContext()).getPlurals();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetRaws() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.RAW;
        final ResourceReflector reflector = Mirror.of(getContext()).getRaws();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetStrings() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.STRING;
        final ResourceReflector reflector = Mirror.of(getContext()).getStrings();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetStyleables() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.STYLEABLE;
        final ResourceReflector reflector = Mirror.of(getContext()).getStyleables();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetStyles() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.STYLE;
        final ResourceReflector reflector = Mirror.of(getContext()).getStyles();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }

    public void testGetXmls() throws Exception {
        assertEquals(0, Mirror.getNumberOfMirrors());
        final ResourceType type = ResourceType.XML;
        final ResourceReflector reflector = Mirror.of(getContext()).getXmls();
        assertNotNull(reflector);
        assertEquals(type, reflector.getResourceType());
        assertEquals(reflector, Mirror.of(getContext()).get(type));
    }
}