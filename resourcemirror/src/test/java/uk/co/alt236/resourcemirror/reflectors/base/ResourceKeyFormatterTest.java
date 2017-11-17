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


import org.junit.Before;
import org.junit.Test;

import uk.co.alt236.resourcemirror.testing.BaseRobolectricTest;

import static org.junit.Assert.assertEquals;

public class ResourceKeyFormatterTest extends BaseRobolectricTest {
    private static final String KEY = "submarine";
    private static final String FAMILY = "family";
    private static final String PREFIX = "ic_";

    private ResourceKeyFormatter mFormatter;

    @Before
    public void setUp(){
        this.mFormatter = new ResourceKeyFormatter();
    }

    @Test
    public void testFormatKey1() throws Exception {
        assertEquals(KEY, mFormatter.formatKey(KEY, null));
        assertEquals(FAMILY + "_" + KEY, mFormatter.formatKey(KEY, FAMILY));
    }

    @Test
    public void testFormatKey() throws Exception {
        assertEquals(KEY, mFormatter.formatKey(null, KEY, null));
        assertEquals(FAMILY + "_" + KEY, mFormatter.formatKey(null, KEY, FAMILY));
        assertEquals(PREFIX + FAMILY + "_" + KEY, mFormatter.formatKey(PREFIX, KEY, FAMILY));
    }
}