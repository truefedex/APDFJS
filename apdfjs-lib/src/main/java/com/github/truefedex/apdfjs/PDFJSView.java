package com.github.truefedex.apdfjs;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;

/**
 * Created by PDT on 02.06.2017.
 */

public class PDFJSView extends WebView {
    public PDFJSView(Context context) {
        super(context);
        init();
    }

    public PDFJSView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PDFJSView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            getSettings().setAllowFileAccessFromFileURLs(true);
            getSettings().setAllowUniversalAccessFromFileURLs(true);
        }

        setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    public void loadFromAssets(String pdfAssetsPath) {
        loadUrl("file:///android_asset/pdfjs-1.7.225-dist/web/viewer.html?file=file:///android_asset/" +
                URLEncoder.encode(pdfAssetsPath));
    }

    public void loadFromFile(String pdfFilePath) {
        loadUrl("file:///android_asset/pdfjs-1.7.225-dist/web/viewer.html?file=file://" +
                URLEncoder.encode(pdfFilePath));
    }

    public void loadFromURL(String pdfURL) {
        loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdfURL);
    }
}
