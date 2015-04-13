# FireSearch 1.0
##Generic search functionality for Android apps.

FireSearch is a generic, easy to use library that allows users carry out search functions in a Search View. In addition, it remembers
a user's search and is not constrained by 'Recent Searches.' Feel free to download, use and imporve this library as there will be planned updates
and more fucntionalities added fro time to time.

####Setting up FireSearch
1.Note: this library is recomended for Sdk Versions 14 and above and for use in Android Studio.

2.In your 'app' directory, make sure its build.gradle file compiles the below or latest support appcompat following in its dependencies:

```java
dependencies {
    ...
    compile 'com.android.support:appcompat-v7:21.0.3'
}
```
![ScreenShot](https://s3.amazonaws.com/uploads.hipchat.com/20526/362297/RVSVCcUEvPGaU9Z/Screen%20Shot%202015-04-13%20at%207.00.47%20PM.png)

3.In your manifest file, create a new search intent filter inside the activity's tag that will be using this feature:

```java
<activity
 ...
  <intent-filter>
    <action android:name="android.intent.action.SEARCH" />
   </intent-filter>
</activity>
```
Afterwards, ensure you are using the following permisions (put this outside your application tag)

```java
<uses-permissionandroid:name="android.permission.READ_USER_DICTIONARY"/>
<uses-permission android:name="android.permission.WRITE_USER_DICTIONARY"/>
```
    
    
4.Still in your manifest, create a 'meta-data' this time inside your application tag. Make sure it is spelt exactly 'searchable' (we will create its xml file shortly):

```java
<application
  ...
   <meta-data android:name="android.app.searchable"
      android:resource="@xml/searchable"
    />
</application>
```

5.Navigate the /res folder of your application, create a new folder called 'xml' and then create a 'searchable.xml' file. Name this exactly as is
because the Android system looks for this in your manifest adn add the following to the 'searchable.xml' file.

```java
<?xml version="1.0" encoding="utf-8"?>
<searchable xmlns:android="http://schemas.android.com/apk/res/android"
    android:label="@string/app_name"
    android:hint="@string/search" //whatever text hint you want
    android:searchSuggestAuthority="android.provider.UserDictionary"
    android:searchSuggestIntentAction="android.intent.action.VIEW"
    android:searchSuggestIntentData="content://user_dictionary/words"
    >
</searchable>
```

6.In your /res/menu folder, edit whatever menu xml file you will be working with to look similar to the below. This is for the menu:

```java
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    
    <item android:id="@+id/menu_search" //name your id what you'd like
           android:title="@string/search" //same for your title
            app:showAsAction="ifRoom|collapseActionView" //configure this as you see fit; though this works good
            android:actionViewClass="android.widget.SearchView" //leave this as is, except you see otherwise
        app:actionViewClass="android.widget.SearchView" //leave this as is, except you see otherwise
        android:icon="@drawable/search"// @ any drawable you would want to represent your search icon 
    />
    
</menu>
```

Now you're ready to extend the FireSearch library from your class and make use of its pre-set features.
