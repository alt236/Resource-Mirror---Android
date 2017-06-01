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
package uk.co.alt236.resourcemirrorsampleapp.activities.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourcetypes.ResourceTypesActivityIntentFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final int LAYOUT_ID = R.layout.activity_main;


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);
        final ListView listView = (ListView) findViewById(android.R.id.list);
        final ListAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                createPackageArray());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(final AdapterView<?> parent,
                            final View view,
                            final int position,
                            final long id) {

        final String label = ((TextView) view.findViewById(android.R.id.text1)).getText().toString();
        final Intent intent = ResourceTypesActivityIntentFactory.create(this, label);
        ActivityCompat.startActivity(this, intent, null);
    }

    private String[] createPackageArray() {
        return new String[]{
                Mirror.getPackageName(this),
                "android",
                "android.support.v7.appcompat"};
    }
}
