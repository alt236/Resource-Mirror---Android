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

package uk.co.alt236.resourcemirrorsampleapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.ListAdapter;
import android.widget.ListView;

import uk.co.alt236.resourcemirror.reflectors.Mirror;
import uk.co.alt236.resourcemirror.util.ResourceType;

public abstract class BaseListActivity extends AppCompatActivity {
    private ResourceType mResourceType;
    private ListView mListView;

    protected Mirror geMirror() {
        final String packageName = getIntent().getExtras().getString(MainActivity.EXTRA_PACKAGE_NAME, null);
        if(packageName == null){
            return Mirror.of(this);
        } else {
            return Mirror.of(packageName);
        }
    }

    public ListView getListView(){
        return mListView;
    }

    protected ResourceType getResourceType() {
        return mResourceType;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Bundle b = getIntent().getExtras();
        if (b != null && !TextUtils.isEmpty(b.getString(ResourceListActivity.EXTRA_RESOURCE_NAME))) {
            mResourceType = ResourceType.fromString(b.getString(ResourceListActivity.EXTRA_RESOURCE_NAME));
            setTitle(mResourceType.getResourceName());
        }
    }

    @Override
    public void setContentView(final int layoutId){
        super.setContentView(layoutId);
        mListView = (ListView) findViewById(android.R.id.list);
    }

    public void setListAdapter(final ListAdapter adapter){
        getListView().setAdapter(adapter);
    }
}
