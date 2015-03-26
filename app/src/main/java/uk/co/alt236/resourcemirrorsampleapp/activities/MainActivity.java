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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.alt236.resourcemirrorsampleapp.R;

public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_PACKAGE_NAME = "EXTRA_PACKAGE_NAME";
    private static final String[] PACKAGES = {
            "Context",
            "android",
            "android.support.v7.appcompat"
    };

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView = (ListView) findViewById(android.R.id.list);
        final ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, PACKAGES);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final String label = ((TextView) view.findViewById(android.R.id.text1)).getText().toString();
        final Intent intent;
        final Bundle bundle = new Bundle();

        if (label == null) {
            intent = null;
        } else {
            intent = new Intent(this, ResourceListActivity.class);
        }

        if (intent == null) {
            Toast.makeText(this, "Intent not setup for " + label, Toast.LENGTH_SHORT).show();
        } else {
            // Ok, if the text contains a '.' it is a package name
            // Else, it means the default context...
            final String packageName;
            if(label.indexOf('.') == -1){
                packageName = null;
            } else {
                packageName = label;
            }

            bundle.putString(EXTRA_PACKAGE_NAME, packageName);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}
