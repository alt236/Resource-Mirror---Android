package uk.co.alt236.resourcemirror.reflectors;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.co.alt236.resourcemirror.ResourceType;
import uk.co.alt236.resourcemirror.reflectors.base.AbstractResourceReflector;
import uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector;

public class ReflectorFactory {
    private final Object mResourceLoaderCreationLock = new Object();
    private final Map<ResourceType, AbstractResourceReflector> mResourceLoaders;
    private final String mPackageName;

    public ReflectorFactory(final String packageName) {
        mPackageName = packageName;
        mResourceLoaders = new HashMap<>();
    }

    /**
     * Gets the appropriate Resource loader for the requested {@link ResourceType};
     *
     * @param resource the {@link ResourceType} needed.
     * @return the {@link uk.co.alt236.resourcemirror.reflectors.base.ResourceReflector} requested
     * @throws java.lang.IllegalArgumentException if an unknown or null {@link ResourceType} is requested.
     */
    public ResourceReflector get(final ResourceType resource) {
        final ResourceReflector retVal;
        if (resource == null) {
            throw new IllegalArgumentException("Cannot have null as a resource type...");
        } else {
            switch (resource) {
                case ANIM:
                    retVal = getAnimations();
                    break;
                case ANIMATOR:
                    retVal = getAnimators();
                    break;
                case ARRAY:
                    retVal = getArrays();
                    break;
                case ATTR:
                    retVal = getAttrs();
                    break;
                case BOOL:
                    retVal = getBooleans();
                    break;
                case COLOR:
                    retVal = getColors();
                    break;
                case DIMEN:
                    retVal = getDimens();
                    break;
                case DRAWABLE:
                    retVal = getDrawables();
                    break;
                case FRACTION:
                    retVal = getFractions();
                    break;
                case ID:
                    retVal = getIds();
                    break;
                case INTEGER:
                    retVal = getIntegers();
                    break;
                case INTERPOLATOR:
                    retVal = getInterpolators();
                    break;
                case LAYOUT:
                    retVal = getLayouts();
                    break;
                case MENU:
                    retVal = getMenus();
                    break;
                case MIPMAP:
                    retVal = getMipMaps();
                    break;
                case PLURALS:
                    retVal = getPlurals();
                    break;
                case RAW:
                    retVal = getRaws();
                    break;
                case STRING:
                    retVal = getStrings();
                    break;
                case STYLEABLE:
                    retVal = getStyleables();
                    break;
                case STYLE:
                    retVal = getStyles();
                    break;
                case XML:
                    retVal = getXmls();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown resource type '" + resource + "'");
            }
        }
        return retVal;
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
}
