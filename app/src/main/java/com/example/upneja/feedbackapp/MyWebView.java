package com.example.upneja.feedbackapp;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MyWebView extends AppCompatActivity {
    WebView mWebView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);
      //  button = (Button) findViewById(R.id.bt);
         mWebView = (WebView) findViewById( R.id.webview);
        mWebView.setWebViewClient(new myWebClient());

        if (Build.VERSION.SDK_INT >= 19) {
            // chromium, enable hardware acceleration
            mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        } else {
            // older android version, disable hardware acceleration
            mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        mWebView.getSettings().setJavaScriptEnabled(true);
        String pdfurl = "www.unm.edu/~unmvclib/powerpoint/pptexamples.ppt"; // Url of pdf or doc file.http://www.tutorialspoint.com/java/java_tutorial.pdf
        //
        String weblink="http://docs.google.com/gview?embedded=true&url="+pdfurl;
        mWebView.loadUrl(weblink);
    }
    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);


        }
    }

    // To handle "Back" key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}