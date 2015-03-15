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
package uk.co.alt236.resourcemirrorsampleapp.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import uk.co.alt236.resourcemirror.reflectors.Mirror;
import uk.co.alt236.resourcemirror.util.ResourceType;

public class GenericAdapter extends ArrayAdapter<String>{
	private final static int mLayout = android.R.layout.simple_list_item_2;

	private final List<String> mItemList;
	private final Mirror mMirror;
	private final ResourceType mResourceType;
    private final LayoutInflater mLayoutInflater;

	public GenericAdapter(final Context context, final Mirror mirror, final ResourceType resourceType, final List<String> itemList) {
		super(context, mLayout);
		mItemList = itemList;
        mMirror = mirror;
		mResourceType = resourceType;
        mLayoutInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(final int position, final View convertView, final ViewGroup parent) {

		final View row;
		final Wrapper wrapper;

		if (convertView == null) {
			row = mLayoutInflater.inflate(mLayout, null);
			wrapper = new Wrapper(row);
			row.setTag(wrapper);
		} else {
            row = convertView;
			wrapper = (Wrapper) row.getTag();
		}

		wrapper.populateFrom(getItem(position));

		return (row);
	}

	@Override
	public String getItem(final int position) {
		return mItemList.get(position);
	}

	@Override
	public int getCount() {
		return mItemList.size();
	}

	private class Wrapper {

		private TextView name = null;
		private TextView id = null;

		private View row = null;

		public Wrapper(final View row) {
			this.row = row;
		}

		public TextView getName() {
			if (name == null) {
				name = (TextView) row.findViewById(android.R.id.text1);
			}
			return(name);
		}

		public TextView getId() {
			if (id == null) {
				id = (TextView) row.findViewById(android.R.id.text2);
			}
			return(id);
		}

		public void populateFrom(final String resourceName) {
			if (resourceName != null) {
				final long id = mMirror.getReflector(mResourceType).optResourceId(resourceName, 0);
				getName().setText(resourceName);

				if(id > 0){
					getId().setText("0x" + Long.toHexString(id));
				} else {
					getId().setText("Not found");
				}
			}
		}
	}
}
