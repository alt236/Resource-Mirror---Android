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

package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.TextUtils;

import uk.co.alt236.resourcemirror.reflectors.Mirror;
import uk.co.alt236.resourcemirror.util.ResourceType;
import uk.co.alt236.resourcemirrorsampleapp.activities.MainActivity;

public abstract class BaseListActivity extends ListActivity {
    private ResourceType mResourceType;

    protected Mirror geMirror() {
        //return Mirror.of("android");
        return Mirror.of(this);
    }

    protected ResourceType getResourceType() {
        return mResourceType;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle b = getIntent().getExtras();
        if (b != null && !TextUtils.isEmpty(b.getString(MainActivity.EXTRA_RESOURCE_NAME))) {
            mResourceType = ResourceType.fromString(b.getString(MainActivity.EXTRA_RESOURCE_NAME));
            setTitle(mResourceType.getResourceName());
        }
    }
}
