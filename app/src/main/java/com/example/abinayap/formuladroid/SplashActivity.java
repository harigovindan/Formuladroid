package com.example.abinayap.formuladroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by abinayap on 11/14/2015.
 */
public class SplashActivity extends Activity {
    private int splashTime = 10000;
    private Thread thread;
    private ProgressBar mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSpinner = (ProgressBar) findViewById(R.id.Splash_ProgressBar);
        mSpinner.setIndeterminate(true);
        thread = new Thread(runable);
        thread.start();
    }
    public Runnable runable = new Runnable() {
        public void run() {
            try {
                Thread.sleep(splashTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    };
}