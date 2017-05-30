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

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListAdapter;

import java.util.List;

import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.activities.BaseListActivity;
import uk.co.alt236.resourcemirrorsampleapp.util.DrawableAdapter;

public class DrawableCheckActivity extends BaseListActivity {
    private static final int LAYOUT_ID = R.layout.activity_generic_list;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT_ID);
        getListView().setBackgroundColor(Color.parseColor("#c0c0c0"));

        final List<String> resourceList = geMirror().get(getResourceType()).getResourceList();
        final ListAdapter adapter = new DrawableAdapter(this, geMirror(), resourceList);
        getListView().setAdapter(adapter);
    }
}
