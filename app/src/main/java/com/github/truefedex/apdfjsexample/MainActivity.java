package com.github.truefedex.apdfjsexample;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import com.github.truefedex.apdfjs.PDFJSView;

import java.io.File;

public class MainActivity extends Activity {

    private PDFJSView apdfjs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apdfjs = (PDFJSView)findViewById(R.id.apdfjs);
    }

    public void loadFromAssetsClick(View view) {
        apdfjs.loadFromAssets("compressed.tracemonkey-pldi-09.pdf");
    }

    public void loadFromFileSystem(View view) {
        File file = new File(Environment.getExternalStorageDirectory() + "/test.pdf");
        if (!file.exists()) {
            Toast.makeText(this, "File not exists:\n" + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
            return;
        }
        apdfjs.loadFromFile(file.getAbsolutePath());
    }

    public void loadFromURL(View view) {
        apdfjs.loadFromURL("http://www.adobe.com/content/dam/Adobe/en/devnet/acrobat/pdfs/pdf_open_parameters.pdf");
    }
}
