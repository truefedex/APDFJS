package com.github.truefedex.apdfjs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

/**
 * Created by PDT on 02.06.2017.
 */

public class PDFJSView extends FrameLayout {
    private WebView webView;

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

    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        webView = new WebView(getContext());
        addView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            webView.getSettings().setAllowFileAccessFromFileURLs(true);
            webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        }

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
    }

    public void loadFromAssets(String pdfAssetsPath) {
        webView.loadUrl("file:///android_asset/pdfjs-1.7.225-dist/web/viewer.html?file=file:///android_asset/" +
                Uri.encode(pdfAssetsPath, "UTF-8"));
    }

    public void loadFromFile(String pdfFilePath) {
        webView.loadUrl("file:///android_asset/pdfjs-1.7.225-dist/web/viewer.html?file=file://" +
                Uri.encode(pdfFilePath, "UTF-8"));
    }
}
