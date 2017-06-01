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

package uk.co.alt236.resourcemirrorsampleapp.activities.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import uk.co.alt236.resourcemirror.Mirror;

public abstract class BaseListActivity extends AppCompatActivity {
    private static final String TAG = BaseListActivity.class.getSimpleName();

    private ListView mListView;

    protected Mirror getMirror() {
        final String packageName = getIntent().getExtras().getString(CommonExtras.EXTRA_PACKAGE_NAME, null);
        if(packageName == null){
            throw new IllegalStateException("No package name passed. Did you forget to set " + CommonExtras.EXTRA_PACKAGE_NAME + "?");
        } else {
            final Mirror mirror = Mirror.of(packageName);
            Log.d(TAG, "Asked for mirror for " + packageName + ", got: " + mirror.getPackageName());
            return mirror;
        }
    }

    public ListView getListView(){
        return mListView;
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void setContentView(final int layoutId){
        super.setContentView(layoutId);
        mListView = (ListView) findViewById(android.R.id.list);
    }

    public void setListAdapter(final ListAdapter adapter){
        getListView().setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
