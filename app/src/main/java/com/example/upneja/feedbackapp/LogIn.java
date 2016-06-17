package com.example.upneja.feedbackapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;

import static java.lang.Thread.sleep;

public class LogIn extends AppCompatActivity {
    private static final int SPLASH_DURATION = 10000;
    ProgressBar mProgressBar;
    boolean mbActive;
    Button loginBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        loginBt =(Button)findViewById(R.id.login_button);
        loginBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setProgressBar();
            }
        });

    }
    public void setProgressBar()
    {
        mProgressBar = (ProgressBar)findViewById(R.id.progressbar);
        mProgressBar.setVisibility(View.VISIBLE);

        Thread loginThread = new Thread(new Runnable() {
            @Override
            public void run() {
                mbActive = true;
                try {
                    int waited = 0;
                    while (mbActive && (waited < SPLASH_DURATION)) {
                        sleep(150);
                        if (mbActive) {
                            waited += 500;
                            updateProgress(waited);
                        }
                    }
                } catch (InterruptedException e) {
                } finally {
                   onContinue();
                }
            }
        });
        loginThread.start();
    }
    public void updateProgress(final int timePasses) {
        if (mProgressBar != null) {
            final int progress = mProgressBar.getMax() * timePasses / SPLASH_DURATION;
            mProgressBar.setProgress(progress);

        }
    }
    public void onContinue() {

        Intent intent = new Intent(LogIn.this,MyWebView.class);

        startActivity(intent);
        finish();
    }
}
