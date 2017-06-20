package com.example.abinayap.formuladroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    final Context context = this;
    int selectedTextViewId;
    float op = 0.5f;

    public void calculateResult(final int id, final View promptsView, final AlertDialog alertDialog)
    {
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a1, b1, result;
                long a,b,asquare,bsquare, acube, bcube;
                long res = 0;
                String aa,bb;

                result = (EditText) promptsView.findViewById(R.id.result_value);
                result.setVisibility(View.VISIBLE);

                a1=(EditText) promptsView.findViewById(R.id.a_value);
                aa=a1.getText().toString();
                b1= (EditText) promptsView.findViewById(R.id.r_value);
                bb=b1.getText().toString();
                a=Long.parseLong(aa);
                b=Long.parseLong(bb);

                asquare = a*a;
                bsquare = b*b;

                acube = asquare*a;
                bcube = bsquare*b;

                if (id == R.id.try_1a)
                    res=(a-b)*(a+b);
                else if(id == R.id.try_2a)
                    res = (a-b) * (asquare + (a*b) + bsquare);
                else if(id == R.id.try_3a)
                    res = (a+b) * (asquare - (a*b) + bsquare);
                else if(id == R.id.try_4a)
                    res = asquare + (2*a*b) + bsquare;
                else if(id == R.id.try_5a)
                    res = asquare - (2*a*b) + bsquare;
                else if(id == R.id.try_6a)
                    res = acube + ( 3*asquare*b) + (3*a*bsquare) + bcube;
                else if(id == R.id.try_7)
                    res = acube - ( 3*asquare*b) + (3*a*bsquare) - bcube;

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

        result = (EditText) promptsView.findViewById(R.id.result_value);
        result.setVisibility(View.INVISIBLE);

        if (wantToCloseDialog)
            alertDialog.cancel();
    }

    @Override

    public void onClick(final View view) {

        selectedTextViewId = view.getId();
        LayoutInflater li = LayoutInflater.from(context);
        final View promptsView = li.inflate(R.layout.algebra_formula_one, null);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_algebra);
        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        intent.getStringExtra("Button");
        String name  = bundle.getString("Button");
        if (name.equals("Algebra")) {
            TextView anim1 = (TextView) findViewById(R.id.try_1a);
            animation(anim1);anim1 = (TextView) findViewById(R.id.try_2a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_3a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_4a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_5a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_6a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_7);animation(anim1);
            TextView first = (TextView) findViewById(R.id.textView1);
            first.setText(Html.fromHtml("a<sup>2</sup> - b<sup>2</sup> = (a-b)(a+b)"));
            TextView second = (TextView) findViewById(R.id.textView2);
            second.setText(Html.fromHtml("a<sup>3</sup> - b<sup>3</sup> = (a - b) (a<sup>2</sup> + ab + b<sup>2</sup>) "));
            TextView third = (TextView) findViewById(R.id.textView3);
            third.setText(Html.fromHtml("a<sup>3</sup> + b<sup>3</sup> = (a + b)(a<sup>2</sup> - ab + b<sup>2</sup>)"));
            TextView fourth = (TextView) findViewById(R.id.textView4);
            fourth.setText(Html.fromHtml("(a + b)<sup>2</sup> = a<sup>2</sup> + 2ab + b<sup>2</sup>"));
            TextView fifth = (TextView) findViewById(R.id.textView5);
            fifth.setText(Html.fromHtml("(a - b)<sup>2</sup> = a<sup>2</sup> - 2ab +b<sup>2</sup>"));
            TextView sixth = (TextView) findViewById(R.id.textView6);
            sixth.setText(Html.fromHtml("(a + b)<sup>3</sup> = a<sup>3</sup> + 3a<sup>2</sup>b + 3ab<sup>2</sup> + b<sup>3</sup>"));
            TextView seventh = (TextView) findViewById(R.id.textView7);
            seventh.setText(Html.fromHtml("(a - b)<sup>3</sup> = a<sup>3</sup> - 3a<sup>2</sup>b + 3ab<sup>2</sup> - b<sup>3</sup>"));
            Button button1;
            button1 = (Button) findViewById(R.id.Button1);
            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //Toast.makeText(MainActivity.this, "Button Clicked",
                    //      Toast.LENGTH_SHORT).show();
                    view.playSoundEffect(SoundEffectConstants.CLICK);
                    Intent intent = new Intent(SecondActivity.this, SecondBActivity.class);
                    startActivity(intent);
                }
            });
        }
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
