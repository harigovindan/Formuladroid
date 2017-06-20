package com.example.abinayap.formuladroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by abinayap on 11/14/2015.
 */
public class SecondBActivity extends AppCompatActivity {
    TextView text;
    final Context context = this;
    int selectedTextViewId;
    float op = 0.5f;
    public void calculateResult(final int id, final View promptsView, final AlertDialog alertDialog)
    {
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a1, r1, n1, result;double a, r, n;
                double res = 0;
                String aa, rr,nn;
                result = (EditText) promptsView.findViewById(R.id.result_value);
                result.setVisibility(View.VISIBLE);
                a1 = (EditText) promptsView.findViewById(R.id.a_value);
                aa = a1.getText().toString();
                r1 = (EditText) promptsView.findViewById(R.id.r_value);
                rr = r1.getText().toString();
                n1=(EditText)promptsView.findViewById(R.id.n_value);
                nn=n1.getText().toString();
                a = Double.parseDouble(aa);
                r = Double.parseDouble(rr);
                n=Double.parseDouble(nn);
                if (id == R.id.try_1a) {
                    r=r+n;
                    if(r==0){res=1;}
                    else
                    {
                        res=Math.pow(a,r);
                    }
                }
                else if(id == R.id.try_2a){
                    r=r-n;
                    if(r==0){res=1;}
                    else
                    {
                        res=Math.pow(a,r);
                    }
                }

                else if(id == R.id.try_3a){
                    r=r*n;
                    if(r==0){res=1;}
                    else
                    {
                        res=Math.pow(a,r);
                    }
                }
                else if(id == R.id.try_4a){
                    if(n==0){res=1;}
                    else
                    {
                        double res1=Math.pow(a,n);
                        double res2=Math.pow(r,n);
                        res=res1*res2;
                    }
                }
                else if(id == R.id.try_5a){
                    if(n==0){res=1;}
                    else
                    {
                        double res1=Math.pow(a,n);
                        double res2=Math.pow(r,n);
                        res=res1/res2;
                    }

                }
                else if(id == R.id.try_6a){
                    if(r/n==0){res=1;}
                    else
                    {
                        double res1=Math.pow(a,r);
                        double res2=Math.pow(res1,1/n);
                        res=res2;
                    }
                }
                String tmp;
                tmp = String.valueOf(res);
                result.setText(tmp);
                Boolean wantToCloseDialog = false;

                if (wantToCloseDialog)
                    alertDialog.dismiss();
            }
        });

        alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields(promptsView, alertDialog);
            }
        });
    }
    public void resetFields(View promptsView, AlertDialog alertDialog )
    {
        EditText result;
        Boolean wantToCloseDialog = false;
        result = (EditText) promptsView.findViewById(R.id.a_value);
        result.setText("");

        result = (EditText) promptsView.findViewById(R.id.r_value);
        result.setText("");

        result = (EditText) promptsView.findViewById(R.id.n_value);
        result.setText("");

        result = (EditText) promptsView.findViewById(R.id.result_value);
        result.setVisibility(View.INVISIBLE);

        if (wantToCloseDialog)
            alertDialog.cancel();
    }
    // @Override
    public void onClick(final View view) {

        selectedTextViewId = view.getId();
        LayoutInflater li = LayoutInflater.from(context);
        final View promptsView = li.inflate(R.layout.algebra_formula_two, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptsView);
        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("CALCULATE",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                .setNeutralButton("RESET",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        })
                .setNegativeButton("CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        final AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        calculateResult(selectedTextViewId, promptsView, alertDialog);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button1,button2;
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_algebra_two);
            TextView anim1 = (TextView) findViewById(R.id.try_1a);
            animation(anim1);anim1 = (TextView) findViewById(R.id.try_2a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_3a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_4a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_5a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_6a);animation(anim1);
            TextView first = (TextView) findViewById(R.id.textView1);
            first.setText(Html.fromHtml("a<sup>m</sup> . a<sup>n</sup> = a<sup>m + n</sup>"));
            TextView second = (TextView) findViewById(R.id.textView2);
            second.setText(Html.fromHtml("a<sup>m</sup> / a<sup>n</sup> = a<sup>m - n</sup> "));
            TextView third = (TextView) findViewById(R.id.textView3);
            third.setText(Html.fromHtml("(a<sup>m</sup>)<sup>n</sup> = a<sup>mn</sup>"));
            TextView fourth = (TextView) findViewById(R.id.textView4);
            fourth.setText(Html.fromHtml("(am)<sup>n</sup> = a<sup>n</sup>m<sup>n</sup>"));
            TextView fifth = (TextView) findViewById(R.id.textView5);
            fifth.setText(Html.fromHtml("(a/m)<sup>n</sup> = a<sup>n</sup> / m<sup>n</sup>"));
            TextView sixth = (TextView) findViewById(R.id.textView6);
            sixth.setText(Html.fromHtml("a<sup>m/n</sup> = (a<sup>m</sup>)<sup>1/n</sup>"));
        button1 = (Button) findViewById(R.id.Button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(SecondBActivity.this,MainActivity.class);
                intent.putExtra("Button", "Home");
                startActivity(intent);
            }
        });
        button2 = (Button) findViewById(R.id.Button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Button Clicked",
                //      Toast.LENGTH_SHORT).show();
                view.playSoundEffect(SoundEffectConstants.CLICK);
                Intent intent = new Intent(SecondBActivity.this, SecondActivity.class);
                intent.putExtra("Button", "Algebra");
                startActivity(intent);
            }
        });
    }
    public void animation(TextView t)
    {
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(200);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        t.startAnimation(anim);
    }
}