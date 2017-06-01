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
package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.generic;


import android.content.Context;
import android.view.View;

import java.util.List;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common.CommonViewHolder;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common.ResourceAdapter;

/*package*/ class GenericAdapter extends ResourceAdapter {

    private final ResourceType mResourceType;

    public GenericAdapter(final Context context,
                          final Mirror mirror,
                          final ResourceType resourceType,
                          final List<String> itemList) {

        super(context, mirror, itemList);
        mResourceType = resourceType;
    }


    protected void populate(final Mirror mirror,
                            final CommonViewHolder wrapper,
                            final String resourceName) {

        final int resId = mirror.get(mResourceType).optResourceId(resourceName, 0);
        wrapper.getImage().setVisibility(View.GONE);
        wrapper.setTitle(resourceName);
        wrapper.setResourceId(resId);

        if (resId == 0) {
            wrapper.setValue(getContext().getString(R.string.resource_not_found));
        } else {
            final String value;
            switch (mResourceType) {
                case STRING:
                    value = getContext().getString(resId);
                    break;
                case INTEGER:
                    value = String.valueOf(getContext().getResources().getInteger(resId));
                    break;
                case BOOL:
                    value = String.valueOf(getContext().getResources().getBoolean(resId));
                    break;
                default:
                    value = null;
            }

            wrapper.setValue(value);
        }
    }
}
