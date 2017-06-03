Resource Mirror
-----------

Were you ever in a situation where you had to access android Resources based on their names (for example if the names are stored in a DB) and you had to write long lookup tables converting the names into R.XXXX.ids? And maintaining them?

This library is offering a way around it by using reflection to access the Resource directly by name.

You only need to include them as normal into your Res folder tree.
It uses LRU caching to mitigate the reflection time overhead.
It also includes a few convenience functions to help change Drawable colour based on a hex colour value.

In essence, this is a suped up version of [https://github.com/alt236/Reflective-Drawable-Loader---Android]() that deals with all Resource types instead of just Drawables.

Usage
-----------
This project is available as an artifact for use with Gradle. To use that, add the following blocks to your `build.gradle` file:

```groovy
	repositories {
		maven {
			url "https://dl.bintray.com/alt236/maven"
		}
	}

	dependencies {
    compile 'uk.co.alt236:resource-mirror-android:1.0.0'
	}
```

Usage
-----------
<b>Quick and easy</b>

The most common use case would be to call on of the following:

`Mirror.of(Context).getXXX().getResourceId("resourceName");` or
`Mirror.of(Context).getXXX().optResourceId("resourceName", R.xxx.fallbackResource);`

where `XXX` is the reource type (String, Drawable, Layout, etc.)
The difference between the two calls are as follows:

|Method|Effect|
|------|------|
|`getXXXId()`|will throw a `android.content.res.Resources.NotFoundException` if the resource is missing|
|`optXXXId()`|will return the fallback resource passed as a parameter if the resource is missing|

<b>Accessing a different package</b>

You can access the resources of a different package by calling

`Mirror.of("packageNameBeforeR");`

for example:
`Mirror.of("android")` will give you access to the `android.R.*` Resources.

<b>Additional Methods</b>

You can also use the following method to get a Resource:

`Mirror.of(Context).getReflector(ResourceType.XXX)` where `ResourceType` is an enum.

If you only have the type of a Resource as a String, you can use the `ResourceType.fromString()` method to get its enum value.

For example the following command will try to fetch the id of a string called "hello"

`Mirror.of(Context).get(ResourceType.fromString("string")).getResourceId("hello");`

<b>Geting a list of all resource names of a type</b>

Simply call:
`Mirror.of(Context).getXXX().getResourceList()`

Note that this will not add the found resources to the LRU cache

Resource families
-----------

The library is using a concept of resource families to distinguish between different variations of similar resoueces (of the same type).
For example, icons in Android can come in a Holo Light and Holo Dark variant.

So, if you call `optDrawableId("submarine", "yellow", R.drawable.ic_list_fallback)` then the library will try to look for an icon called `yellow_submarine` and return its Id if it exists, or `R.drawable.ic_list_fallback` otherwise.

Similarly, if you call `optDrawableId("submarine", null, R.drawable.ic_list_fallback)` or  `getDrawableId("submarine", R.drawable.ic_list_fallback)` then the library will try to look for an icon called `submarine` and return its Id if it exists, or `R.drawable.ic_list_fallback` otherwise.

Of course, nothing stops you from calling  `optDrawableId("yellow_submarine", null, R.drawable.ic_list_fallback)` to get the `yellow_submarine` icon as well.

Helper methods for Drawables
-----------
In addition to the normal methods above, there are a number of helper methods for drawables.

<b>Convenience Functions and Drawable naming conventions</b>

The convenience functions in the library assume that Drawables are named using the convention described here [Icon Design Guidelines](http://developer.android.com/guide/practices/ui_guidelines/icon_design.html).

So for example,

If you call `getListDrawableId("submarine", "yellow", R.drawable.ic_list_fallback);` then the library will try to look for an icon called `ic_list_yellow_submarine` and return its Id if it exists, or `R.drawable.ic_list_fallback` otherwise.

<b>Colorising Drawables</b>

If you ask for a Colorised Icon by calling `getColorisedListDrawable("table", "furniture", "#c0c0c0", R.drawable.ic_list_fallback);` instead of an Id you will get a `DrawableResourceContainer` object which will contain the Id of the Drawable to use, the colour to use as and Integer and a couple convenience functions to use to colourise the Drawable. If there was an error parsing the colour, the Integer will be null.

Also, the convenience functions do not apply the colorFilter to the Drawable directly, but to the ImageView holding it.

Feel free to expand the `DrawableResourceContainer` to add other colour filters or behaviours.

ProGuard
--------

ProGuard users must ensure that the R class, its inner R class and all fields are not obfuscated for the runtime reflection to work. Add the following to your your `proguard-project.txt` file:

```
    -keepattributes InnerClasses

    -keep class **.R
    -keep class **.R$* {
        <fields>;
    }
```
Changelog
-----------
* v0.0.1 First public release
* v1.0.0 Added Javadoc, android resource annotations, bugfixes

Permission Explanation
-----------
* No permissions required

Links
-----------
* Github: [https://github.com/alt236/Resource-Mirror---Android]()

Credits
-----------
Author: [Alexandros Schillings](https://github.com/alt236).

Based on code by [Jeff Gilfelt](https://github.com/jgilfelt), who showed me that contrary to my academic reservations, reflectively loading resources is not that bad :)

All logos are the property of their respective owners.

The icons used for the example app were downloaded from here: [Android Design](http://developer.android.com/design/downloads/index.htm)

The code in this project is licensed under the Apache Software License 2.0.

Copyright (c) 2015 Alexandros Schillings.
