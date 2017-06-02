# APDFJS
Simple Android library (webview based) for viewing pdf files using Mozilla's [PDF.js](https://mozilla.github.io/pdf.js) library for wieving local pdf files.

<img src="/screenshot.png" alt="Demo" width="300px" />

##### Usage

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

```groovy
dependencies {
	compile 'com.github.truefedex:APDFJS:v1.0'
}
```

Now add widget to your layout:
```xml
<com.github.truefedex.apdfjs.PDFJSView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/apdfjs"/>
```

And use simple api:
```java
PDFJSView apdfjs = (PDFJSView)findViewById(R.id.apdfjs);
apdfjs.loadFromAssets("compressed.tracemonkey-pldi-09.pdf");
```


### Stuff used to make this:

 * [PDF.js](https://mozilla.github.io/pdf.js) for displaying pdf in webview
