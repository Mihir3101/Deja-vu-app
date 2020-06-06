package com.faltu.dejavu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TttGameActivity extends AppCompatActivity {

    Button a00,a01,a02,a10,a11,a12,a20,a21,a22,restart;
    int count=0;
    //Default is 0
    //for X a[][] is 1 & for O a[][] is 2
    int[][] arr=new int[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttt_game);
        a00=(Button)findViewById(R.id.a00);
        a01=(Button)findViewById(R.id.a01);
        a02=(Button)findViewById(R.id.a02);
        a10=(Button)findViewById(R.id.a10);
        a11=(Button)findViewById(R.id.a11);
        a12=(Button)findViewById(R.id.a12);
        a20=(Button)findViewById(R.id.a20);
        a21=(Button)findViewById(R.id.a21);
        a22=(Button)findViewById(R.id.a22);
        restart=(Button)findViewById(R.id.restart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a00.setEnabled(true);
                a00.setText("Click Me *_*");
                a01.setEnabled(true);
                a01.setText("Click Me *_*");
                a02.setEnabled(true);
                a02.setText("Click Me *_*");
                a10.setEnabled(true);
                a10.setText("Click Me *_*");
                a11.setEnabled(true);
                a11.setText("Click Me *_*");
                a12.setEnabled(true);
                a12.setText("Click Me *_*");
                a20.setEnabled(true);
                a20.setText("Click Me *_*");
                a21.setEnabled(true);
                a21.setText("Click Me *_*");
                a22.setEnabled(true);
                a22.setText("Click Me *_*");
                count=0;
            }
        });

        a00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a00.setText("X");
                    arr[0][0]=1;
                }else{
                    a00.setText("O");
                    arr[0][0]=2;
                }
                a00.setEnabled(false);
                count++;
                check();
            }
        });
        a01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a01.setText("X");
                    arr[0][1]=1;
                }else{
                    a01.setText("O");
                    arr[0][1]=2;
                }
                count++;
                a01.setEnabled(false);
                check();
            }
        });
        a02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a02.setText("X");
                    arr[0][2]=1;
                }else{
                    a02.setText("O");
                    arr[0][2]=2;
                }
                a02.setEnabled(false);
                count++;
                check();
            }
        });
        a10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a10.setText("X");
                    arr[1][0]=1;
                }else{
                    a10.setText("O");
                    arr[1][0]=2;
                }
                a10.setEnabled(false);
                count++;
                check();
            }
        });
        a11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a11.setText("X");
                    arr[1][1]=1;
                }else{
                    a11.setText("O");
                    arr[1][1]=2;
                }
                a11.setEnabled(false);
                count++;
                check();
            }
        });
        a12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a12.setText("X");
                    arr[1][2]=1;
                }else{
                    a12.setText("O");
                    arr[1][2]=2;
                }
                a12.setEnabled(false);
                count++;
                check();
            }
        });
        a20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a20.setText("X");
                    arr[2][0]=1;
                }else{
                    a20.setText("O");
                    arr[2][0]=2;
                }
                a20.setEnabled(false);
                count++;
                check();
            }
        });
        a21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a21.setText("X");
                    arr[2][1]=1;
                }else{
                    a21.setText("O");
                    arr[2][1]=2;
                }
                a21.setEnabled(false);
                count++;
                check();
            }
        });
        a22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count%2==0)
                {
                    a22.setText("X");
                    arr[2][2]=1;
                }else{
                    a22.setText("O");
                    arr[2][2]=2;
                }
                a22.setEnabled(false);
                count++;
                check();
            }
        });
    }
    public void check()
    {
        if((arr[0][0]==1&&arr[0][1]==1&&arr[0][2]==1)||(arr[1][0]==1&&arr[1][1]==1&&arr[1][2]==1)||(arr[2][0]==1&&arr[2][1]==1&&arr[2][2]==1)||(arr[0][0]==1&&arr[1][0]==1&&arr[2][0]==1)||(arr[0][1]==1&&arr[1][1]==1&&arr[2][1]==1)||(arr[0][2]==1&&arr[1][2]==1&&arr[2][2]==1)||(arr[0][0]==1&&arr[1][1]==1&&arr[2][2]==1)||(arr[0][2]==1&&arr[1][1]==1&&arr[2][0]==1))
        {
            Toast.makeText(TttGameActivity.this,"X Win The game!! Congratulation",Toast.LENGTH_SHORT).show();
            a00.setEnabled(true);
            a00.setText("Click Me *_*");
            a01.setEnabled(true);
            a01.setText("Click Me *_*");
            a02.setEnabled(true);
            a02.setText("Click Me *_*");
            a10.setEnabled(true);
            a10.setText("Click Me *_*");
            a11.setEnabled(true);
            a11.setText("Click Me *_*");
            a12.setEnabled(true);
            a12.setText("Click Me *_*");
            a20.setEnabled(true);
            a20.setText("Click Me *_*");
            a21.setEnabled(true);
            a21.setText("Click Me *_*");
            a22.setEnabled(true);
            a22.setText("Click Me *_*");
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    arr[i][j]=0;
                }
            }
            count=0;
        }else if((arr[0][0]==2&&arr[0][1]==2&&arr[0][2]==2)||(arr[1][0]==2&&arr[1][1]==2&&arr[1][2]==2)||(arr[2][0]==2&&arr[2][1]==2&&arr[2][2]==2)||(arr[0][0]==2&&arr[1][0]==2&&arr[2][0]==2)||(arr[0][1]==2&&arr[1][1]==2&&arr[2][1]==2)||(arr[0][2]==2&&arr[1][2]==2&&arr[2][2]==2)||(arr[0][0]==2&&arr[1][1]==2&&arr[2][2]==2)||(arr[0][2]==2&&arr[1][1]==2&&arr[2][0]==2))
        {
            Toast.makeText(TttGameActivity.this,"O Win The game!! Congratulation",Toast.LENGTH_SHORT).show();
            a00.setEnabled(true);
            a00.setText("Click Me *_*");
            a01.setEnabled(true);
            a01.setText("Click Me *_*");
            a02.setEnabled(true);
            a02.setText("Click Me *_*");
            a10.setEnabled(true);
            a10.setText("Click Me *_*");
            a11.setEnabled(true);
            a11.setText("Click Me *_*");
            a12.setEnabled(true);
            a12.setText("Click Me *_*");
            a20.setEnabled(true);
            a20.setText("Click Me *_*");
            a21.setEnabled(true);
            a21.setText("Click Me *_*");
            a22.setEnabled(true);
            a22.setText("Click Me *_*");
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    arr[i][j]=0;
                }
            }
            count=0;
        }
        if(count==9)
        {
            Toast.makeText(TttGameActivity.this, "MATCH - DRAW ", Toast.LENGTH_SHORT).show();
            a00.setEnabled(true);
            a00.setText("Click Me *_*");
            a01.setEnabled(true);
            a01.setText("Click Me *_*");
            a02.setEnabled(true);
            a02.setText("Click Me *_*");
            a10.setEnabled(true);
            a10.setText("Click Me *_*");
            a11.setEnabled(true);
            a11.setText("Click Me *_*");
            a12.setEnabled(true);
            a12.setText("Click Me *_*");
            a20.setEnabled(true);
            a20.setText("Click Me *_*");
            a21.setEnabled(true);
            a21.setText("Click Me *_*");
            a22.setEnabled(true);
            a22.setText("Click Me *_*");
            for(int i=0;i<3;i++)
            {
                for(int j=0;j<3;j++)
                {
                    arr[i][j]=0;
                }
            }
            count=0;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TttGameActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
