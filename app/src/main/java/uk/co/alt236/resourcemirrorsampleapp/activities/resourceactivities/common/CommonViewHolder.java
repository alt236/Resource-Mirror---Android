package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import uk.co.alt236.resourcemirrorsampleapp.R;

public class CommonViewHolder {
    public static final int LAYOUT = R.layout.list_item_common;

    private final View row;
    private final Resources resources;
    private final TextView title;
    private final TextView resId;
    private final TextView value;
    private final ImageView image;

    public CommonViewHolder(final View row) {
        this.row = row;
        this.image = (ImageView) row.findViewById(R.id.icon);
        this.title = (TextView) row.findViewById(R.id.title);
        this.resId = (TextView) row.findViewById(R.id.resId);
        this.value = (TextView) row.findViewById(R.id.value);
        this.resources = row.getResources();
    }

    public ImageView getImage() {
        return image;
    }

    public void setResourceId(final int resourceId) {
        final String suffix;
        if (resourceId > 0) {
            suffix = String.format("0x%s", Integer.toHexString(resourceId));
        } else {
            suffix = resources.getString(R.string.resource_not_found);
        }
        resId.setText(resources.getString(R.string.prefix_resid, suffix));
    }

    public void setTitle(final String text) {
        title.setText(text);
    }

    public void setValue(final String text) {
        if (text == null) {
            value.setVisibility(View.GONE);
        } else {
            value.setVisibility(View.VISIBLE);
            value.setText(resources.getString(R.string.prefix_value, text));
        }
    }
}
