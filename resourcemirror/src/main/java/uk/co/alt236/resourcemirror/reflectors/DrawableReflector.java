package uk.co.alt236.resourcemirror.reflectors;

/*******************************************************************************
 * Copyright 2013 Alexandros Schillings
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

	protected DrawableReflector(String packageName) {
		super(packageName);
		mAddDrawableNameToContainer = new AtomicBoolean(false);
	}

	private DrawableResourceContainer fetchDrawableContainer(String drawableName, String color, int fallbackDrawableId) {
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
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return The Id of the Drawable to display.
	 */
	public int optDialogDrawable(String drawableName, String family, int fallbackDrawableId) {
		return optResourceId(ICON_PREFIX_DIALOG + mKeyFormatter.formatKey(drawableName, family), fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch Dialog
	 * Drawables without having to mess around with String concatenation in your
	 * code. The Drawable filename in the Res folder needs to be prefixed with
	 * {@value #ICON_PREFIX_DIALOG}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optDialogDrawableContainer(String drawableName, String family, String colorString, int fallbackDrawableId) {
		return fetchDrawableContainer(ICON_PREFIX_DIALOG + mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
	}

	/**
	 * This function will return {@link DrawableResourceContainer} containing
	 * the requested Drawable information This function makes no assumptions
	 * regarding a Drawable's prefix, so you will need input its full name. It
	 * is functionally identical to calling getDrawableContainer(drawableName,
	 * family, colorString, fallbackDrawableId) with the family set to null.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optDrawableContainer(String drawableName, String colorString, int fallbackDrawableId) {
		return optDrawableContainer(drawableName, null, colorString, fallbackDrawableId);
	}

	/**
	 * This function will return {@link DrawableResourceContainer} containing
	 * the requested Drawable information <b>This function makes no assumptions
	 * regarding a Drawable's prefix, so you will need input its full name.</b>
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optDrawableContainer(String drawableName, String family, String colorString, int fallbackDrawableId) {
		return fetchDrawableContainer(mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch
	 * Launcher Drawables without having to mess around with String
	 * concatenation in your code. The Drawable filename in the Res folder needs
	 * to be prefixed with {@value #ICON_PREFIX_LAUNCHER}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optLauncherDrawableContainer(String drawableName, String family, String colorString, int fallbackDrawableId) {
		return fetchDrawableContainer(ICON_PREFIX_LAUNCHER + mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch
	 * Launcher Drawables without having to mess around with String
	 * concatenation in your code. The Drawable filename in the Res folder needs
	 * to be prefixed with {@value #ICON_PREFIX_LAUNCHER}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return The Id of the Drawable to display.
	 */
	public int optLauncherDrawableId(String drawableName, String family, int fallbackDrawableId) {
		return optResourceId(ICON_PREFIX_LAUNCHER + mKeyFormatter.formatKey(drawableName, family), fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch List
	 * Drawables without having to mess around with String concatenation in your
	 * code. The Drawable filename in the Res folder needs to be prefixed with
	 * {@value #ICON_PREFIX_LIST}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optListDrawableContainer(String drawableName, String family, String colorString, int fallbackDrawableId) {
		return fetchDrawableContainer(ICON_PREFIX_LIST + mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch List
	 * Drawables without having to mess around with String concatenation in your
	 * code. The Drawable filename in the Res folder needs to be prefixed with
	 * {@value #ICON_PREFIX_LIST}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return The Id of the Drawable to display.
	 */
	public int optListDrawableId(String drawableName, String family, int fallbackDrawableId) {
		return optResourceId(ICON_PREFIX_LIST + mKeyFormatter.formatKey(drawableName, family), fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch Menu
	 * Drawables without having to mess around with String concatenation in your
	 * code. The Drawable filename in the Res folder needs to be prefixed with
	 * {@value #ICON_PREFIX_MENU}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optMenuDrawableContainer(String drawableName, String family, String colorString, int fallbackDrawableId) {
		return fetchDrawableContainer(ICON_PREFIX_MENU + mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch Menu
	 * Drawables without having to mess around with String concatenation in your
	 * code. The Drawable filename in the Res folder needs to be prefixed with
	 * {@value #ICON_PREFIX_MENU}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return The Id of the Drawable to display.
	 */
	public int optMenuDrawableId(String drawableName, String family, int fallbackDrawableId) {
		return optResourceId(ICON_PREFIX_MENU + mKeyFormatter.formatKey(drawableName, family), fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch Status
	 * Bar Drawables without having to mess around with String concatenation in
	 * your code. The Drawable filename in the Res folder needs to be prefixed
	 * with {@value #ICON_PREFIX_STATUS_BAR}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optStatusBarDrawableContainer(String drawableName, String family, String colorString, int fallbackDrawableId) {
		return fetchDrawableContainer(ICON_PREFIX_STATUS_BAR + mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch Status
	 * Bar Drawables without having to mess around with String concatenation in
	 * your code. The Drawable filename in the Res folder needs to be prefixed
	 * with {@value #ICON_PREFIX_STATUS_BAR}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return The Id of the Drawable to display.
	 */
	public int optStatusBarDrawableId(String drawableName, String family, int fallbackDrawableId) {
		return optResourceId(ICON_PREFIX_STATUS_BAR + mKeyFormatter.formatKey(drawableName, family), fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch Tab
	 * Drawables without having to mess around with String concatenation in your
	 * code. The Drawable filename in the Res folder needs to be prefixed with
	 * {@value #ICON_PREFIX_TAB}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param colorString
	 *            The colour used for the colour filter. It has to be in
	 *            "#FFFFFF" format.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return A {@link DrawableResourceContainer} with the requested Drawable
	 *         data.
	 */
	public DrawableResourceContainer optTabDrawableContainer(String drawableName, String family, String colorString, int fallbackDrawableId) {
		return fetchDrawableContainer(ICON_PREFIX_TAB + mKeyFormatter.formatKey(drawableName, family), colorString, fallbackDrawableId);
	}

	/**
	 * This is a convenience function which can be used to quickly fetch Tab
	 * Drawables without having to mess around with String concatenation in your
	 * code. The Drawable filename in the Res folder needs to be prefixed with
	 * {@value #ICON_PREFIX_TAB}.
	 *
	 * @param drawableName
	 *            The name of the Drawable to fetch.
	 * @param family
	 *            The family (if any) of the variable to fetch. Set to null if
	 *            no family is needed.
	 * @param fallbackDrawableId
	 *            The id of the Drawable to use if the requested one does not
	 *            exist.
	 * @return The Id of the Drawable to display.
	 */
	public int optTabDrawableId(String drawableName, String family, int fallbackDrawableId) {
		return optResourceId(ICON_PREFIX_TAB + mKeyFormatter.formatKey(drawableName, family), fallbackDrawableId);
	}

	/**
	 * Enables or disables the addition of the requested Drawable name in the
	 * resulting {@link DrawableResourceContainer} when requesting a Colorised
	 * Drawable.
	 *
	 * @param enable
	 *            - True to enable, false to disable. False by default;
	 */
	public synchronized void setAddDrawableNameToContainer(boolean enable) {
		mAddDrawableNameToContainer.set(enable);
	}

	private Integer tryColor(String colorString) {
		if (colorString == null || colorString.length() < 1) {
			return null;
		}

		try {
			return Color.parseColor(colorString);
		} catch (IllegalArgumentException e) {
			if (isErrorLoggingEnabled()) {
				Log.w(TAG, "tryColor() - IllegalArgumentException while trying to parse color '" + colorString + "'");
			}
			return null;
		}
	}
}