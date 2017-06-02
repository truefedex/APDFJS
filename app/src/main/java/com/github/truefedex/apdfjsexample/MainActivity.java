package com.github.truefedex.apdfjsexample;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.github.truefedex.apdfjs.PDFJSView;

import java.io.File;

public class MainActivity extends Activity {

    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 10000;
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
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            return;
        }
        File file = new File(Environment.getExternalStorageDirectory() + "/test.pdf");
        if (!file.exists()) {
            Toast.makeText(this, "File not exists:\n" + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
            return;
        }
        apdfjs.loadFromFile(file.getAbsolutePath());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    loadFromFileSystem(null);
                } else {
                    Toast.makeText(this, "Read external storage not permitted", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
