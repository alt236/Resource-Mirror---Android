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

package uk.co.alt236.resourcemirror.reflectors;

import android.graphics.Color;
import android.util.Log;

import java.util.concurrent.atomic.AtomicBoolean;

import uk.co.alt236.resourcemirror.containers.DrawableResourceContainer;
import uk.co.alt236.resourcemirror.reflectors.base.AbstractResourceReflector;
import uk.co.alt236.resourcemirror.util.ResourceType;

public final class DrawableReflector extends AbstractResourceReflector {
    public static final String ICON_PREFIX_BASE = "ic_";
    public static final String ICON_PREFIX_LAUNCHER = ICON_PREFIX_BASE + "launcher_";
    public static final String ICON_PREFIX_MENU = ICON_PREFIX_BASE + "menu_";
    public static final String ICON_PREFIX_STATUS_BAR = ICON_PREFIX_BASE + "stat_notify_";
    public static final String ICON_PREFIX_TAB = ICON_PREFIX_BASE + "tab_";
    public static final String ICON_PREFIX_DIALOG = ICON_PREFIX_BASE + "dialog_";
    public static final String ICON_PREFIX_LIST = ICON_PREFIX_BASE + "list_";

    private final String TAG = getClass().getName();
    private final AtomicBoolean mAddDrawableNameToContainer;
    private static final ResourceType RESOURCE_TYPE = ResourceType.DRAWABLE;

    private DrawableReflector() {
        // We should never be here...
        super(null);
        Log.e(TAG, THE_DEFAULT_CONSTRUCTOR_WAS_CALLED);
        throw new IllegalStateException(THE_DEFAULT_CONSTRUCTOR_WAS_CALLED);
    }

    protected DrawableReflector(final String packageName) {
        super(packageName);
        mAddDrawableNameToContainer = new AtomicBoolean(false);
    }

    private DrawableResourceContainer fetchDrawableContainer(final String drawableName, final String color, final int fallbackDrawableId) {
        final int res = optResourceId(drawableName, fallbackDrawableId);
        return new DrawableResourceContainer((mAddDrawableNameToContainer.get() ? drawableName : null), res, tryColor(color));
    }

    @Override
    protected String getLogTag() {
        return TAG;
    }

    @Override
    public ResourceType getResourceType() {
        return RESOURCE_TYPE;
    }

    /**
     * This is a convenience function which can be used to quickly fetch Dialog
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_DIALOG}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return The Id of the Drawable to display.
     */
    public int optDialogDrawable(final String drawableName, final String family, final int fallbackDrawableId) {
        return optResourceId(mKeyFormatter.formatKey(ICON_PREFIX_DIALOG, drawableName, family), fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch Dialog
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_DIALOG}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optDialogDrawableContainer(final String drawableName, final String family, final String colorString, final int fallbackDrawableId) {
        return fetchDrawableContainer(mKeyFormatter.formatKey(ICON_PREFIX_DIALOG, drawableName, family), colorString, fallbackDrawableId);
    }

    /**
     * This function will return {@link DrawableResourceContainer} containing
     * the requested Drawable information This function makes no assumptions
     * regarding a Drawable's prefix, so you will need input its full name. It
     * is functionally identical to calling getDrawableContainer(drawableName,
     * family, colorString, fallbackDrawableId) with the family set to null.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optDrawableContainer(final String drawableName, final String colorString, final int fallbackDrawableId) {
        return optDrawableContainer(drawableName, null, colorString, fallbackDrawableId);
    }

    /**
     * This function will return {@link DrawableResourceContainer} containing
     * the requested Drawable information <b>This function makes no assumptions
     * regarding a Drawable's prefix, so you will need input its full name.</b>
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optDrawableContainer(final String drawableName, final String family, final String colorString, final int fallbackDrawableId) {
        return fetchDrawableContainer(mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch
     * Launcher Drawables without having to mess around with String
     * concatenation in your code. The Drawable filename in the Res folder needs
     * to be prefixed with {@value #ICON_PREFIX_LAUNCHER}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optLauncherDrawableContainer(final String drawableName, final String family, final String colorString, final int fallbackDrawableId) {
        return fetchDrawableContainer(mKeyFormatter.formatKey(ICON_PREFIX_LAUNCHER, drawableName, family), colorString, fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch
     * Launcher Drawables without having to mess around with String
     * concatenation in your code. The Drawable filename in the Res folder needs
     * to be prefixed with {@value #ICON_PREFIX_LAUNCHER}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return The Id of the Drawable to display.
     */
    public int optLauncherDrawableId(final String drawableName, final String family, final int fallbackDrawableId) {
        return optResourceId(mKeyFormatter.formatKey(ICON_PREFIX_LAUNCHER, drawableName, family), fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch List
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_LIST}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optListDrawableContainer(final String drawableName, final String family, final String colorString, final int fallbackDrawableId) {
        return fetchDrawableContainer(mKeyFormatter.formatKey(ICON_PREFIX_LIST, drawableName, family), colorString, fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch List
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_LIST}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return The Id of the Drawable to display.
     */
    public int optListDrawableId(final String drawableName, final String family, final int fallbackDrawableId) {
        return optResourceId(mKeyFormatter.formatKey(ICON_PREFIX_LIST, drawableName, family), fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch Menu
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_MENU}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optMenuDrawableContainer(final String drawableName, final String family, final String colorString, final int fallbackDrawableId) {
        return fetchDrawableContainer(mKeyFormatter.formatKey(ICON_PREFIX_MENU, drawableName, family), colorString, fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch Menu
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_MENU}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return The Id of the Drawable to display.
     */
    public int optMenuDrawableId(final String drawableName, final String family, final int fallbackDrawableId) {
        return optResourceId(mKeyFormatter.formatKey(ICON_PREFIX_MENU, drawableName, family), fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch Status
     * Bar Drawables without having to mess around with String concatenation in
     * your code. The Drawable filename in the Res folder needs to be prefixed
     * with {@value #ICON_PREFIX_STATUS_BAR}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optStatusBarDrawableContainer(final String drawableName, final String family, final String colorString, final int fallbackDrawableId) {
        return fetchDrawableContainer(mKeyFormatter.formatKey(ICON_PREFIX_STATUS_BAR, drawableName, family), colorString, fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch Status
     * Bar Drawables without having to mess around with String concatenation in
     * your code. The Drawable filename in the Res folder needs to be prefixed
     * with {@value #ICON_PREFIX_STATUS_BAR}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return The Id of the Drawable to display.
     */
    public int optStatusBarDrawableId(final String drawableName, final String family, final int fallbackDrawableId) {
        return optResourceId(mKeyFormatter.formatKey(ICON_PREFIX_STATUS_BAR, drawableName, family), fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch Tab
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_TAB}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param colorString        The colour used for the colour filter. It has to be in
     *                           "#FFFFFF" format.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return A {@link DrawableResourceContainer} with the requested Drawable
     * data.
     */
    public DrawableResourceContainer optTabDrawableContainer(final String drawableName, final String family, final String colorString, final int fallbackDrawableId) {
        return fetchDrawableContainer(mKeyFormatter.formatKey(ICON_PREFIX_TAB, drawableName, family), colorString, fallbackDrawableId);
    }

    /**
     * This is a convenience function which can be used to quickly fetch Tab
     * Drawables without having to mess around with String concatenation in your
     * code. The Drawable filename in the Res folder needs to be prefixed with
     * {@value #ICON_PREFIX_TAB}.
     *
     * @param drawableName       The name of the Drawable to fetch.
     * @param family             The family (if any) of the variable to fetch. Set to null if
     *                           no family is needed.
     * @param fallbackDrawableId The id of the Drawable to use if the requested one does not
     *                           exist.
     * @return The Id of the Drawable to display.
     */
    public int optTabDrawableId(final String drawableName, final String family, final int fallbackDrawableId) {
        return optResourceId(mKeyFormatter.formatKey(ICON_PREFIX_TAB, drawableName, family), fallbackDrawableId);
    }

    /**
     * Enables or disables the addition of the requested Drawable name in the
     * resulting {@link DrawableResourceContainer} when requesting a Colorised
     * Drawable.
     *
     * @param enable - True to enable, false to disable. False by default;
     */
    public synchronized void setAddDrawableNameToContainer(final boolean enable) {
        mAddDrawableNameToContainer.set(enable);
    }

    private Integer tryColor(final String colorString) {
        if (colorString == null || colorString.length() < 1) {
            return null;
        }

        try {
            return Color.parseColor(colorString);
        } catch (final IllegalArgumentException e) {
            if (isErrorLoggingEnabled()) {
                Log.w(TAG, "tryColor() - IllegalArgumentException while trying to parse color '" + colorString + "'");
            }
            return null;
        }
    }
}
