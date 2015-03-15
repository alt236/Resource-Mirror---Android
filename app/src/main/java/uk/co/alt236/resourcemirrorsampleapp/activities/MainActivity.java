/*******************************************************************************
 * Copyright 2013 alex
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.alt236.resourcemirrorsampleapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import uk.co.alt236.resourcemirror.util.ResourceType;
import uk.co.alt236.resourcemirrorsampleapp.R;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.BaseListActivity;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.DrawableCheckActivity;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.GenericCheckActivity;

public class MainActivity extends BaseListActivity{
	public static final String EXTRA_RESOURCE_NAME = "EXTRA_RESOURCE_NAME";

	ListAdapter mAdapter;

	@Override
	public void onCreate(final Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final List<String> resources = geMirror().getResourceTypes();

		Collections.sort(resources);

		final ListAdapter adapter = new ArrayAdapter<String>(
				this,
				android.R.layout.simple_list_item_1,
				android.R.id.text1,
				resources);

		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(final ListView l, final View v, final int position, final long id) {
		final String resourceName = ((TextView) v.findViewById(android.R.id.text1)).getText().toString();


		final Intent intent;
		final Bundle bundle = new Bundle();

		if(resourceName == null){
			intent = null;
		} else {
			final ResourceType type = ResourceType.fromString(resourceName);
			if(type == null){
				intent = null;
			} else {
				switch(type){
				case ANIM:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case ANIMATOR:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case ARRAY:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case ATTR:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case BOOL:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case COLOR:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case DIMEN:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case DRAWABLE:
					intent = new Intent(this, DrawableCheckActivity.class);
					break;
				case FRACTION:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case ID:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case INTEGER:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case INTERPOLATOR:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case LAYOUT:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case MENU:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case MIPMAP:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case PLURALS:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case RAW:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case STRING:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case STYLEABLE:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case STYLE:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				case XML:
					intent = new Intent(this, GenericCheckActivity.class);
					break;
				default:
					intent = null;
					break;
				}
			}
		}

		if(intent == null){
			Toast.makeText(this, "Intent not setup for " + resourceName, Toast.LENGTH_SHORT).show();
		} else {
			bundle.putString(EXTRA_RESOURCE_NAME, resourceName);
			intent.putExtras(bundle);
			startActivity(intent);
		}
	}
}
