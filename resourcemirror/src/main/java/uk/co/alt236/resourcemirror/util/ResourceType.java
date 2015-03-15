package uk.co.alt236.resourcemirror.util;

public enum ResourceType {
	ANIM("anim"),
	ANIMATOR("animator"),
	ARRAY("array"),
	ATTR("attr"),
	BOOL("bool"),
	COLOR("color"),
	DIMEN("dimen"),
	DRAWABLE("drawable"),
	FRACTION("fraction"),
	ID("id"),
	INTEGER("integer"),
	INTERPOLATOR("interpolator"),
	LAYOUT("layout"),
	MENU("menu"),
	MIPMAP("mipmap"),
	PLURALS("plurals"),
	RAW("raw"),
	STRING("string"),
	STYLE("style"),
	STYLEABLE("styleable"),
	XML("xml");

	private final String mResourceName;
	private ResourceType(final String name){
		mResourceName = name;
	}

	public String getResourceName(){
		return mResourceName;
	}

	public static ResourceType fromString(final String string){
		for(final ResourceType type : ResourceType.values()){
			if(type.getResourceName().equals(string)){
				return type;
			}
		}

		return null;
	}
}
