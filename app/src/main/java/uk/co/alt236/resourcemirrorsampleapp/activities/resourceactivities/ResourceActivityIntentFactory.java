package uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirrorsampleapp.activities.common.CommonExtras;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.color.ColorCheckActivity;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.common.ResourceListActivity;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.drawable.DrawableCheckActivity;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.generic.GenericCheckActivity;
import uk.co.alt236.resourcemirrorsampleapp.activities.resourceactivities.mipmap.MipmapCheckActivity;

public final class ResourceActivityIntentFactory {
    private ResourceActivityIntentFactory() {
        // NOOP
    }

    public static Intent createIntentFor(@NonNull final Context context,
                                         @NonNull final String packageName,
                                         @NonNull final ResourceType type) {
        final Intent intent;

        switch (type) {
            case COLOR:
                intent = new Intent(context, ColorCheckActivity.class);
                break;
            case DRAWABLE:
                intent = new Intent(context, DrawableCheckActivity.class);
                break;
            case MIPMAP:
                intent = new Intent(context, MipmapCheckActivity.class);
                break;
            default:
                intent = new Intent(context, GenericCheckActivity.class);
        }

        final Bundle bundle = new Bundle();
        bundle.putString(CommonExtras.EXTRA_PACKAGE_NAME, packageName);
        bundle.putString(ResourceListActivity.EXTRA_RESOURCE_NAME, type.getResourceName());
        intent.putExtras(bundle);

        return intent;
    }
}
