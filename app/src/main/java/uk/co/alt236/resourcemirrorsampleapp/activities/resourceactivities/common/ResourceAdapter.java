package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Random;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirror.reflectors.base.ResourceKeyFormatter;

public abstract class ResourceAdapter extends ArrayAdapter<String> {
    private final static int LAYOUT = CommonViewHolder.LAYOUT;
    private final List<String> mItemList;
    private final Random mRandom;
    private final Mirror mMirror;
    private final LayoutInflater mLayoutInflater;
    private final ResourceKeyFormatter mKeyFormatter;

    public ResourceAdapter(final Context context,
                           final Mirror mirror,
                           final List<String> itemList) {

        super(context, LAYOUT);
        mKeyFormatter = new ResourceKeyFormatter();
        mItemList = itemList;
        mMirror = mirror;
        mRandom = new Random();
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(final int position,
                        final View convertView,
                        @NonNull final ViewGroup parent) {

        final View row;
        final CommonViewHolder wrapper;

        if (convertView == null) {
            row = mLayoutInflater.inflate(LAYOUT, null);
            wrapper = new CommonViewHolder(row);
            row.setTag(wrapper);
        } else {
            row = convertView;
            wrapper = (CommonViewHolder) row.getTag();
        }

        populate(mMirror, wrapper, getItem(position));
        return row;
    }

    @Override
    public String getItem(final int position) {
        return mItemList.get(position);
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    protected abstract void populate(final Mirror mirror,
                                     final CommonViewHolder viewHolder,
                                     final String resourceId);
}
