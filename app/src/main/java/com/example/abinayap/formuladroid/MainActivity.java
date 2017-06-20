package com.example.abinayap.formuladroid;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(MainActivity.this, Progression.class);
                intent.putExtra("Button", "Progression");
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.Button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("Button", "Algebra");
                startActivity(intent);
            }
        });
        button3 = (Button) findViewById(R.id.Button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(MainActivity.this, Trigonometry.class);
                intent.putExtra("Button", "Trigonometry");
                startActivity(intent);
            }
        });
        button4 = (Button) findViewById(R.id.Button4);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(MainActivity.this, Measurements.class);
                intent.putExtra("Button", "Measurements");
                startActivity(intent);
            }
        });
        button5 = (Button) findViewById(R.id.Button5);
        button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(MainActivity.this, Integration.class);
                intent.putExtra("Button", "Integration");
                startActivity(intent);
            }
        });
    }
}
