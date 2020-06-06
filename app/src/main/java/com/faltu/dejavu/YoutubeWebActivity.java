package com.faltu.dejavu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class YoutubeWebActivity extends AppCompatActivity {

    WebView youtube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_web);
        Intent intent =getIntent();
        String SEARCH = intent.getStringExtra("url");
        String URL="";
        for(int i=0;i<SEARCH.length();i++)
        {
            if(SEARCH.charAt(i)!=' ')
            {
                URL+=SEARCH.charAt(i);
            }else if(SEARCH.charAt(i)=='+')
            {
                URL+="%2B";
            }
            else if(SEARCH.charAt(i)=='#')
            {
                URL+="%23";
            }else{
                URL+='+';
            }
        }
        SEARCH="https://www.youtube.com/results?search_query="+URL;
        youtube=(WebView)findViewById(R.id.youtube);
        WebSettings webSettings = youtube.getSettings();
        webSettings.setJavaScriptEnabled(true);
        youtube.loadUrl(SEARCH);
        youtube.setWebViewClient(new WebViewClient());
    }
    @Override
    public void onBackPressed() {
        if (youtube.canGoBack()) {
            youtube.goBack();
        } else {

            super.onBackPressed();
        }
    }
}