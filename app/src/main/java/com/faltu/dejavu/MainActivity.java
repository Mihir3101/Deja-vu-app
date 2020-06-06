package com.faltu.dejavu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_calc,btn_todo,btn_player,btn_game,btn_about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_calc=(Button)findViewById(R.id.btn_calc);
        btn_todo=(Button)findViewById(R.id.btn_todo);
        btn_player=(Button)findViewById(R.id.btn_player);
        btn_game=(Button)findViewById(R.id.btn_game);
        btn_about=(Button)findViewById(R.id.about);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CalcActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TttGameActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VideoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}