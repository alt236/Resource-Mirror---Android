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

package uk.co.alt236.resourcemirrorsampleapp.activities.resourcetypes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import uk.co.alt236.resourcemirror.Mirror;
import uk.co.alt236.resourcemirrorsampleapp.activities.common.CommonExtras;

public final class ResourceTypesActivityIntentFactory {

    private ResourceTypesActivityIntentFactory() {
        // NOOP
    }

    public static Intent create(@NonNull final Context context,
                                @NonNull final String packageName) {

        final Intent intent = new Intent(context, ResourceTypesActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putString(
                CommonExtras.EXTRA_PACKAGE_NAME,
                getPackageName(context, packageName));
        intent.putExtras(bundle);

        return intent;
    }

    private static String getPackageName(final Context context,
                                         final String packageName) {

        final String retVal;

        // Ok, if the text contains a '.' it is a package name
        // Else, it means the default context...
        if (packageName.indexOf('.') == -1) {
            retVal = Mirror.getPackageName(context);
        } else {
            retVal = packageName;
        }

        return retVal;
    }
}
