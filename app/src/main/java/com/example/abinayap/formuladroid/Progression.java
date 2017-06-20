package com.example.abinayap.formuladroid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.TextView;

public class Progression extends AppCompatActivity {
    TextView text;
    final Context context = this;
    int selectedTextViewId;
    float op = 0.5f;
    public void calculateResult(final int id, final View promptsView, final AlertDialog alertDialog)
    {
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText a1, r1, n1, result;long a, r, n;
                long res = 0;
                String aa, rr,nn;
                result = (EditText) promptsView.findViewById(R.id.result_value);
                result.setVisibility(View.VISIBLE);
                a1 = (EditText) promptsView.findViewById(R.id.a_value);
                aa = a1.getText().toString();
                r1 = (EditText) promptsView.findViewById(R.id.r_value);
                rr = r1.getText().toString();
                n1=(EditText)promptsView.findViewById(R.id.n_value);
                nn=n1.getText().toString();
                a = Long.parseLong(aa);
                r = Long.parseLong(rr);
                n=Long.parseLong(nn);
                if (id == R.id.try_1a) {
                    for(int i=0;i<=n;i++)
                    {
                        res+=a*(Math.pow(r,i));
                    }
                }
                else if(id == R.id.try_2a){
                    n=n-1;
                    if(n==0){res=a;}
                    else
                    {
                        for(int i=1;i<=n;i++)
                            {
                                r*=i;
                            }
                        res=a*r;
                    }
                }

                else if(id == R.id.try_3a){
                            if(n==0){res=0;}
                            else
                            {
                                for(int i=1;i<=n;i++)
                                {
                                    r*=i;
                                }
                                res=(a*(1-r))/(1-r);
                            }
                }
                else if(id == R.id.try_4a){
                    TextView t=(TextView)promptsView.findViewById(R.id.enter_m);
                    t.setText("Enter d");
                    for(int i=0;i<=n;i++)
                    {
                        res+=(a+(i*r));
                    }
                }
                else if(id == R.id.try_5a){
                    TextView t=(TextView)promptsView.findViewById(R.id.enter_m);
                    t.setText("Enter d");
                        res=a+(n-1)*r;
                    }
                else if(id == R.id.try_6a){
                    TextView t=(TextView)promptsView.findViewById(R.id.enter_m);
                    t.setText("Enter d");
                    res=(n/2)*((2*a)+((n-1)*r));
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
        final View promptsView = li.inflate(R.layout.progression_formula_one, null);
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
        setContentView(R.layout.activity_progression);
        Bundle bundle = getIntent().getExtras();
        Intent intent = getIntent();
        intent.getStringExtra("Button");
        String name  = bundle.getString("Button");
        if(name.equals("Progression")) {
            TextView anim1 = (TextView) findViewById(R.id.try_1a);
            animation(anim1);anim1 = (TextView) findViewById(R.id.try_2a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_3a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_4a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_5a);animation(anim1);
            anim1 = (TextView) findViewById(R.id.try_6a);animation(anim1);
            TextView second = (TextView) findViewById(R.id.formula_1);
            second.setText(Html.fromHtml("&nbsp;&nbsp;a + ar + ar<sup>2</sup> + ar<sup>3</sup> + ..."));
            TextView third = (TextView) findViewById(R.id.prog2);
            third.setText(Html.fromHtml("&nbsp;&nbsp;N<sup>th</sup>&nbsp;&nbsp;Term"));
            TextView fourth = (TextView) findViewById(R.id.formula_2);
            fourth.setText(Html.fromHtml("&nbsp;&nbsp;Tn = ar<sup>n - 1</sup>"));
            TextView sixth = (TextView) findViewById(R.id.formula_3);
            sixth.setText(Html.fromHtml("&nbsp;&nbsp;Sn=a(1-r<sup>n</sup>)/(1-r)"));
            TextView eighth = (TextView) findViewById(R.id.formula_4);
            eighth.setText(Html.fromHtml("&nbsp;&nbsp;a + (a + d) + (a + 2d) + (a + 3d) + ..."));
            TextView ninth = (TextView) findViewById(R.id.prog5);
            ninth.setText(Html.fromHtml("&nbsp;&nbsp;N<sup>th</sup>&nbsp;&nbsp;Term"));
            TextView tenth = (TextView) findViewById(R.id.formula_5);
            tenth.setText(Html.fromHtml("&nbsp;&nbsp;Tn = a + (n - 1)d"));
            TextView twelveth = (TextView) findViewById(R.id.formula_6);
            twelveth.setText(Html.fromHtml("&nbsp;&nbsp;Sn=n/2[2a +(n - 1)d]"));
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
