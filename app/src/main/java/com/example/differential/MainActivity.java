package com.example.differential;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private WebView myWebview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebview = (WebView) findViewById(R.id.webview);
        if (isNetworkAvailable()){
            WebSettings webSettings = myWebview.getSettings();
            myWebview.loadUrl("http://differential.co.ke/");
            myWebview.setWebViewClient(new WebViewClient());
            webSettings.setJavaScriptEnabled(true);

        }
        else {
            Toast.makeText(this,"Sorry,network is unavailable",
                    Toast.LENGTH_LONG).show();
        }


    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()){
            isAvailable =true;
        }

        return isAvailable;
    }

    @Override
    public void onBackPressed() {
        if (myWebview.canGoBack()){
            myWebview.goBack();
        }
        else{
            super.onBackPressed();
        }

    }


}
