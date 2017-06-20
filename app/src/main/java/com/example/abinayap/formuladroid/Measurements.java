package com.example.abinayap.formuladroid;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;

/**
 * Created by Admin on 11/15/2015.
 */
public class Measurements extends AppCompatActivity {
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_measurements);
        /*button1 = (Button) findViewById(R.id.Button4);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(Measurements.this, Trigonometry_two.class);
                intent.putExtra("Button", "Trigonometry");
                startActivity(intent);
            }
        });*/
    }
}
