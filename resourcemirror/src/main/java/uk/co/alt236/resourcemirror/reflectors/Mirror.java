package uk.co.alt236.resourcemirror.reflectors;

import android.content.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.alt236.resourcemirror.reflectors.base.AbstractResourceReflector;
import uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector;
import uk.co.alt236.resourcemirror.util.ResourceType;

/**
 * ****************************************************************************
 * Copyright 2013 Alexandros Schillings
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance of the License. You may obtain a copy of
 * the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed of an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * ****************************************************************************
 */

public class Mirror {
    private static final Object MAP_LOCK = new Object();
    private static final Map<String, Mirror> MAP_OF_LOADERS = new HashMap<String, Mirror>();

    private final Object mResourceLoaderCreationLock = new Object();

    private final Map<ResourceType, AbstractResourceReflector> mResourceLoaders;
    private final String mPackageName;

    private Mirror(final String packageName) {
        mPackageName = packageName;
        mResourceLoaders = new HashMap<ResourceType, AbstractResourceReflector>();
    }

    public AnimationReflector getAnimations() {
        final ResourceType type = ResourceType.ANIM;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new AnimationReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (AnimationReflector) methodResult;
    }

    public AnimatorReflector getAnimators() {
        final ResourceType type = ResourceType.ANIMATOR;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new AnimatorReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (AnimatorReflector) methodResult;
    }

    public ArrayLoaderReflector getArrays() {
        final ResourceType type = ResourceType.ARRAY;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new ArrayLoaderReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (ArrayLoaderReflector) methodResult;
    }

    public AttrReflector getAttrs() {
        final ResourceType type = ResourceType.ATTR;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new AttrReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (AttrReflector) methodResult;
    }

    public BooleanReflector getBooleans() {
        final ResourceType type = ResourceType.BOOL;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new BooleanReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (BooleanReflector) methodResult;
    }

    public ColorReflector getColors() {
        final ResourceType type = ResourceType.COLOR;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new ColorReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (ColorReflector) methodResult;
    }

    public DimenReflector getDimens() {
        final ResourceType type = ResourceType.DIMEN;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new DimenReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (DimenReflector) methodResult;
    }

    public DrawableReflector getDrawables() {
        final ResourceType type = ResourceType.DRAWABLE;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new DrawableReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (DrawableReflector) methodResult;
    }

    public FractionReflector getFractions() {
        final ResourceType type = ResourceType.FRACTION;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new FractionReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (FractionReflector) methodResult;
    }

    public IdReflector getIds() {
        final ResourceType type = ResourceType.ID;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new IdReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (IdReflector) methodResult;
    }

    public IntegerReflector getIntegers() {
        final ResourceType type = ResourceType.INTEGER;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new IntegerReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (IntegerReflector) methodResult;
    }

    public InterpolatorReflector getInterpolators() {
        final ResourceType type = ResourceType.INTERPOLATOR;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new InterpolatorReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (InterpolatorReflector) methodResult;
    }

    public LayoutReflector getLayouts() {
        final ResourceType type = ResourceType.LAYOUT;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new LayoutReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (LayoutReflector) methodResult;
    }

    /**
     * Gets the appropriate Resource loader for the requested {@link uk.co.alt236.resourcemirror.util.ResourceType};
     *
     * @param resource the {@link uk.co.alt236.resourcemirror.util.ResourceType} needed.
     * @return the {@link uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector} requested
     * @throws java.lang.IllegalArgumentException if an unknown or null {@link uk.co.alt236.resourcemirror.util.ResourceType} is requested.
     */
    public ResourceReflector getReflector(final ResourceType resource) {
        final ResourceReflector methodResult;
        if (resource == null) {
            throw new IllegalArgumentException("Cannot have null as a resource type...");
        } else {
            switch (resource) {
                case ANIM:
                    methodResult = getAnimations();
                    break;
                case ANIMATOR:
                    methodResult = getAnimators();
                    break;
                case ARRAY:
                    methodResult = getArrays();
                    break;
                case ATTR:
                    methodResult = getAttrs();
                    break;
                case BOOL:
                    methodResult = getBooleans();
                    break;
                case COLOR:
                    methodResult = getColors();
                    break;
                case DIMEN:
                    methodResult = getDimens();
                    break;
                case DRAWABLE:
                    methodResult = getDrawables();
                    break;
                case FRACTION:
                    methodResult = getFractions();
                    break;
                case ID:
                    methodResult = getIds();
                    break;
                case INTEGER:
                    methodResult = getIntegers();
                    break;
                case INTERPOLATOR:
                    methodResult = getInterpolators();
                    break;
                case LAYOUT:
                    methodResult = getLayouts();
                    break;
                case MENU:
                    methodResult = getMenus();
                    break;
                case MIPMAP:
                    methodResult = getMipMaps();
                    break;
                case PLURALS:
                    methodResult = getPlurals();
                    break;
                case RAW:
                    methodResult = getRaws();
                    break;
                case STRING:
                    methodResult = getStrings();
                    break;
                case STYLEABLE:
                    methodResult = getStyleables();
                    break;
                case STYLE:
                    methodResult = getStyles();
                    break;
                case XML:
                    methodResult = getXmls();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown resource type '" + resource + "'");
            }
        }
        return methodResult;
    }

    public MenuReflector getMenus() {
        final ResourceType type = ResourceType.MENU;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new MenuReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (MenuReflector) methodResult;
    }

    public MipMapReflector getMipMaps() {
        final ResourceType type = ResourceType.MIPMAP;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new MipMapReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (MipMapReflector) methodResult;
    }

    public PluralsReflector getPlurals() {
        final ResourceType type = ResourceType.PLURALS;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new PluralsReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (PluralsReflector) methodResult;
    }

    public RawReflector getRaws() {
        final ResourceType type = ResourceType.RAW;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new RawReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (RawReflector) methodResult;
    }

    /**
     * Retrieves a list of all Resource types that the R class is aware of.
     *
     * @return the list of Resource types.
     */
    public List<String> getResourceTypes() {
        return getDrawables().getAllResourceTypes();
    }

    public StringReflector getStrings() {
        final ResourceType type = ResourceType.STRING;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new StringReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (StringReflector) methodResult;
    }

    public StyleableReflector getStyleables() {
        final ResourceType type = ResourceType.STYLEABLE;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new StyleableReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (StyleableReflector) methodResult;
    }

    public StyleReflector getStyles() {
        final ResourceType type = ResourceType.STYLE;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new StyleReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (StyleReflector) methodResult;
    }

    public XmlReflector getXmls() {
        final ResourceType type = ResourceType.XML;
        final AbstractResourceReflector methodResult;

        synchronized (mResourceLoaderCreationLock) {
            if (!mResourceLoaders.containsKey(type)) {
                mResourceLoaders.put(type, new XmlReflector(mPackageName));
            }
            methodResult = mResourceLoaders.get(type);

        }

        return (XmlReflector) methodResult;
    }

    /**
     * Returns an instance of the {@link uk.co.alt236.resourcemirror.reflectors.Mirror}
     *
     * @param context A standard Android context. It cannot be null
     * @return The instance of the {@link uk.co.alt236.resourcemirror.reflectors.Mirror}
     */
    public static Mirror of(final Context context) {
        return of(context.getApplicationContext().getPackageName());
    }

    /**
     * Returns an instance of the {@link uk.co.alt236.resourcemirror.reflectors.Mirror}
     *
     * @param packageName The package name to try and reflect off.
     * @return The instance of the {@link uk.co.alt236.resourcemirror.reflectors.Mirror}
     */
    public static Mirror of(final String packageName) {
        synchronized (MAP_LOCK) {
            if (!MAP_OF_LOADERS.containsKey(packageName)) {
                MAP_OF_LOADERS.put(packageName, new Mirror(packageName));
            }
        }

        return MAP_OF_LOADERS.get(packageName);
    }

}
