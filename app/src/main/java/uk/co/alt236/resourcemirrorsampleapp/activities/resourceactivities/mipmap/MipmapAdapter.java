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
package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.mipmap;


import android.content.Context;
import android.graphics.Color;

import java.util.List;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common.CommonViewHolder;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common.ResourceAdapter;

/*package*/ class MipmapAdapter extends ResourceAdapter {
    private final static int FALLBACK = R.drawable.ic_missing_icon;

    public MipmapAdapter(final Context context,
                         final Mirror mirror,
                         final List<String> itemList) {

        super(context, mirror, itemList);
    }

    protected void populate(final Mirror mirror, final CommonViewHolder wrapper, final String resourceName) {
        final int resId = mirror.getMipMaps().optResourceId(
                resourceName,
                0);

        wrapper.getImage().setBackgroundColor(Color.parseColor("#c0c0c0"));
        wrapper.getImage().setImageResource(resId == 0 ? FALLBACK : resId);
        wrapper.setTitle(resourceName);
        wrapper.setResourceId(resId);
    }
}
