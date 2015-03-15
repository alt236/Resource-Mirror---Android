package uk.co.alt236.resourcemirror.reflectors.base;

import android.text.TextUtils;

public class ResourceKeyFormatter {
    public String formatKey(final String name, final String family) {
        if (!TextUtils.isEmpty(family)) {
            return family.concat("_").concat(name);
        } else {
            return name;
        }
    }

    public String formatKey(final String prefix, final String name, final String family) {
        if (!TextUtils.isEmpty(family)) {
            return prefix.concat(family).concat(formatKey(name, family));
        } else {
            return prefix.concat(name);
        }
    }
}
