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

package uk.co.alt236.resourcemirrorsampleapp.activities.resourcetypes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.activities.common.BaseListActivity;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.ResourceActivityIntentFactory;

public class ResourceTypesActivity extends BaseListActivity implements AdapterView.OnItemClickListener {
    private static final int LAYOUT_ID = R.layout.activity_main;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);
        setTitle(getMirror().getPackageName());

        final List<String> resources = getMirror().getResourceTypes();
        Collections.sort(resources);

        final ListAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                resources);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(final AdapterView<?> parent,
                            final View view,
                            final int position,
                            final long id) {

        final String resourceName = ((TextView) view.findViewById(android.R.id.text1)).getText().toString();
        final ResourceType type = ResourceType.fromString(resourceName);
        final Intent intent = ResourceActivityIntentFactory.createIntentFor(
                this,
                getMirror().getPackageName(),
                type);

        ActivityCompat.startActivity(this, intent, null);
    }
}
