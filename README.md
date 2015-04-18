# FireSearch 1.0
##Generic search functionality for Android apps.

[![Join the chat at https://gitter.im/gpshopper/firesearch](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/gpshopper/firesearch?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

FireSearch is a generic, easy to use library that allows users carry out search functions in a Search View. It works by remembering a user's previous search and displays suggestions when words are similar. It is not constrained to just 'Recent Searches.' 

In the near future, or 2.0, there is plan to read, suggest and display search data more dynamically via server requests/responses.


Feel free to download, use and imporve this library as there will be planned updates and more fucntionalities added from time to time.

####Setting up FireSearch
<b>1. </b>Note: this library is recomended for Sdk Versions 14 and above and for use in Android Studio.

<b>2. </b>In your root project directory, not your app directory, make sure its build.gradle file calls mavenCentral:

```java
buildscript {
    repositories {
        ...
        mavenCentral() 
    }
...

allprojects {
    repositories {
        ...
        mavenCentral() 
    }
}
```

<b>3. </b>In your app directory's build.gradle, add the following to your dependency:

```java
dependencies {
    ...
    compile 'com.android.support:appcompat-v7:22.0.0' //Make sure the latest appcompat support is also called
    compile 'com.gpshopper.firesearch:firesearch-lib:1.0.9' //Declare plugin dependency, this is the latest version
}
```

<b>4. </b>Finally, make sure the menu xml layout that will be using the FireSearch feature is named 'menu_search' e.g. R.menu.menu_search.
 
 
 
Now you're ready to extend the FireSearch library from your class and make use of its pre-set features.



####Example

```java
package firesearch.labs.gpshopper.com.testapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gpshopper.labs.firesearch.FireSearch;


public class MainActivity extends FireSearch {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**Menu must be named menu_search*/
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSuggestionClick(int position) {
        /**Override this method to handle what happens on suggestion click*/
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        /**Override this method to handle what happens when user hits 'Go' or 'Search' button
        on the keyboard*/
        return false;
    }
```



##License
```text
The MIT License (MIT)

Copyright (c) 2015 GPShopper LLC

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
