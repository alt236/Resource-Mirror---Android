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
package uk.co.alt236.resourcemirrorsampleapp.util;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import uk.co.alt236.resourcemirror.reflectors.DrawableReflector;
import uk.co.alt236.resourcemirror.reflectors.Mirror;
import uk.co.alt236.resourcemirror.reflectors.base.ResourceKeyFormatter;
import uk.co.alt236.resourcemirrorsampleapp.R;

public class DrawableAdapter extends ArrayAdapter<String> {
    private final static int mLayout = R.layout.list_item_icon_check;
    private final static int mMissingIconId = R.drawable.ic_missing_icon;

    //private final Context mContext;
    private final List<String> mItemList;
    private final Random mRandom;
    private final Mirror mMirror;
    private final LayoutInflater mLayoutInflater;
    private final ResourceKeyFormatter mKeyFormatter;

    public DrawableAdapter(final Context context, final Mirror mirror, final List<String> itemList) {
        super(context, mLayout);
        mKeyFormatter = new ResourceKeyFormatter();
        mItemList = itemList;
        mMirror = mirror;
        mRandom = new Random();
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
        private ImageView image1 = null;

        private View row = null;

        public Wrapper(final View row) {
            this.row = row;
        }

        public ImageView getImage1() {
            if (image1 == null) {
                image1 = (ImageView) row.findViewById(R.id.image1);
            }
            return (image1);
        }

        public TextView getName() {
            if (name == null) {
                name = (TextView) row.findViewById(R.id.name);
            }
            return (name);
        }

        public void populateFrom(final String iconName) {
            if (iconName != null) {

                getImage1().setImageResource(
                        mMirror.getDrawables().optResourceId(
                                iconName,
                                mMissingIconId));

                getName().setText(iconName);
            }
        }
    }
}
