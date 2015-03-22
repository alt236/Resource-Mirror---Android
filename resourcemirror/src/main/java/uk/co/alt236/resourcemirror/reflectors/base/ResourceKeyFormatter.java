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

import android.text.TextUtils;

public class ResourceKeyFormatter {
    public String formatKey(final String name, final String family) {
        if (!TextUtils.isEmpty(family)) {
            return family.concat("_").concat(name);
        } else {
            return name;
        }
    }

    public String formatKey(final String prefix, final String name, final String family) {
        if (!TextUtils.isEmpty(family)) {
            return prefix.concat(family).concat(formatKey(name, family));
        } else {
            return prefix.concat(name);
        }
    }
}
