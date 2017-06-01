package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common;

import android.os.Bundle;

import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirrorsampleapp.activities.common.BaseListActivity;

public abstract class ResourceListActivity extends BaseListActivity {
    public static final String EXTRA_RESOURCE_NAME = ResourceListActivity.class.getName() + ".EXTRA_RESOURCE_NAME";

    private ResourceType mResourceType;

    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);

        final Bundle b = getIntent().getExtras();

        if (b == null) {
            throw new IllegalStateException("Null bundle");
        }

        mResourceType = ResourceType.fromString(b.getString(EXTRA_RESOURCE_NAME, null));

        if (mResourceType == null) {
            throw new IllegalStateException("Null Resource Type");
        }
    }

    protected ResourceType getResourceType() {
        return mResourceType;
    }
}
