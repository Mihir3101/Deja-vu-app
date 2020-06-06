package com.faltu.dejavu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.icu.text.UnicodeSetSpanner;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CalcActivity extends AppCompatActivity {

    private EditText input;
    private Button btn_add;
    private Button btn_sub;
    private Button btn_product;
    private Button btn_div;
    private TextView ans;
    private TextView showTxt;
    private Button clear,result;
    public char last_char='+';
    public int flag=0,inft=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        input = (EditText) findViewById(R.id.etans);
        btn_add = (Button) findViewById(R.id.add);
        btn_sub = (Button) findViewById(R.id.sub);
        btn_product = (Button) findViewById(R.id.product);
        btn_div = (Button) findViewById(R.id.div);
        ans = (TextView) findViewById(R.id.ans);
        clear=(Button)findViewById(R.id.clear);
        result=(Button)findViewById(R.id.result);

        showTxt = (TextView) findViewById(R.id.showText);
        ans.setText("0");


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTxt.setText("");
                ans.setText("0");
                input.setText("");
                last_char='+';
            }
        });

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().equals("")) {
                    Toast.makeText(CalcActivity.this, "Please Enter one Query", Toast.LENGTH_SHORT).show();
                    input.requestFocus();
                } else {
                    if (flag != 1) {
                        String SHOW_TEXT = showTxt.getText().toString();
                        if ((SHOW_TEXT.charAt(SHOW_TEXT.length() - 1) < '0' && input.getText().toString().isEmpty())) {
                            input.requestFocus();
                            Toast.makeText(CalcActivity.this, "Enter a no", Toast.LENGTH_LONG).show();
                        } else if (!input.getText().toString().isEmpty()) {
                            ans.setText(Output_Answer(input.getText().toString(), ans.getText().toString(), last_char));
                            showTxt.setText(showTxt.getText().toString() + input.getText().toString() + " = " + ans.getText().toString());
                            input.setText("");
                            flag = 1;
                        } else {
                            showTxt.setText(showTxt.getText().toString() + input.getText().toString() + " = " + ans.getText().toString());
                            input.setText("");
                            flag = 1;
                        }
                    } else {
                        Toast.makeText(CalcActivity.this, "Press the Clear Button", Toast.LENGTH_SHORT).show();
                        clear.requestFocus();
                    }
                }
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1||inft==1)
                {
                    ans.setText("");
                    showTxt.setText("");
                    ans.setText("0");
                    flag=0;inft=0;
                }
                if (input.getText().toString().isEmpty()) {
                    Toast.makeText(CalcActivity.this, "Input some no.", Toast.LENGTH_SHORT).show();
                    input.requestFocus();
                }
                else
                {
                    //last_no = Double.parseDouble(input.getText().toString());
                    ans.setText(Output_Answer(input.getText().toString(),ans.getText().toString(),last_char));
                    showTxt.setText(showTxt.getText().toString()+input.getText().toString()+" +");
                    input.setText("");
                    last_char='+';
                }
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1||inft==1)
                {
                    ans.setText("");
                    showTxt.setText("");
                    ans.setText("0");
                    flag=0;inft=0;
                }
                if (input.getText().toString().isEmpty()) {
                    Toast.makeText(CalcActivity.this, "Input some no.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //last_no = Double.parseDouble(input.getText().toString());
                    ans.setText(Output_Answer(input.getText().toString(),ans.getText().toString(),last_char));
                    showTxt.setText(showTxt.getText().toString()+input.getText().toString()+"-");
                    input.setText("");
                    last_char ='-';
                }
            }
        });
        btn_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1||inft==1)
                {
                    ans.setText("");
                    showTxt.setText("");
                    ans.setText("0");
                    flag=0;
                    inft=0;
                }
                if (input.getText().toString().isEmpty()) {
                    Toast.makeText(CalcActivity.this, "Input some no.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //last_no = Double.parseDouble(input.getText().toString());
                    ans.setText(Output_Answer(input.getText().toString(),ans.getText().toString(),last_char));
                    showTxt.setText(showTxt.getText().toString()+input.getText().toString()+"*");
                    input.setText("");
                    last_char ='*';
                }
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1||inft==1)
                {
                    ans.setText("");
                    showTxt.setText("");
                    ans.setText("0");
                    flag=0;
                    inft=0;
                }
                if (input.getText().toString().isEmpty()) {
                    Toast.makeText(CalcActivity.this, "Input some no.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //last_no = Double.parseDouble(input.getText().toString());
                    ans.setText(Output_Answer(input.getText().toString(),ans.getText().toString(),last_char));
                    showTxt.setText(showTxt.getText().toString()+input.getText().toString()+"/");
                    last_char ='/';
                    if(ans.getText().toString().equals("INFINITY"))
                    {
                        inft=1;
                        showTxt.setText("");
                        last_char='+';
                    }
                    input.setText("");

                }
            }
        });

    }
    public String Output_Answer(String input,String ans,char a)
    {
        double x=Double.parseDouble(input),y=Double.parseDouble(ans);
        if(a=='+')
        {
            return String.valueOf(y+x);
        }else if(a=='-')
        {
            return String.valueOf(y-x);
        }
        else if(a=='*') {
            if(y==0) {
                return String.valueOf(x);
            }else {
                return String.valueOf(x * y);
            }
        } else if (a == '/'){
            if(x==0)
            {
                return "INFINITY";
            }else{
                return String.valueOf(y/x);
            }
        }
        else {
            return String.valueOf(y+x);
        }
    }

    private long backPressedTime;
    private Toast backToast;
    @Override
    public void onBackPressed() {
        if(backPressedTime+2000>System.currentTimeMillis())
        {
            backToast.cancel();
            super.onBackPressed();
            Intent intent = new Intent(CalcActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            backToast = Toast.makeText(getBaseContext(),"Press back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }
}