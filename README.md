# FireSearch 1.0
##Generic search functionality for Android apps.

FireSearch is a generic, easy to use library that allows users carry out search functions in a Search View. In works by remembering a user's previous search and displays suggestions when words are similar. It is not constrained to just 'Recent Searches.' 

Feel free to download, use and imporve this library as there will be planned updates and more fucntionalities added from time to time.

####Setting up FireSearch
1. Note: this library is recomended for Sdk Versions 14 and above and for use in Android Studio.

2. In your root project directory, not you app directory, make sure its build.gradle file compiles the below or latest support appcompat in its dependencies:

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

3. In your app directory's build.gradle, add the following to your dependency:

```java
dependencies {
    ...
    compile 'com.android.support:appcompat-v7:22.0.0' //Make sure appcompat support is also called
    compile 'com.github.codezee:app:1.0.4' //Declare plugin dependency 
}
```

Now you're ready to extend the FireSearch library from your class and make use of its pre-set features.


##License
```text
The MIT License (MIT)

Copyright (c) 2015 Emmanuel Uwadiegwu

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
