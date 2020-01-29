package com.example.meiyizheng.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView webview = findViewById(R.id.webview);

        webview.getSettings().setJavaScriptEnabled(true);

        webview.setWebViewClient(new WebViewClient());

        // webview.loadUrl("http://www.google.com");

        webview.loadData("<html><body><h1>Hello World!</h1><p> This is my cool website!</p></body></html>", "text/html", "UTF-8");
    }
}
