package com.faltu.dejavu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VideoActivity extends AppCompatActivity {

    Button btn_go;
    TextView input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        btn_go=(Button)findViewById(R.id.btn_go);
        input=(TextView)findViewById(R.id.input);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals(null))
                {
                    Toast.makeText(VideoActivity.this, "Please Enter your interst '_' ", Toast.LENGTH_SHORT).show();
                }
                else{
                    String SEARCH = input.getText().toString();
                    Intent intent= new Intent(VideoActivity.this,YoutubeWebActivity.class);
                    intent.putExtra("url",SEARCH);
                    startActivity(intent);
                    input.setText("");
                }
            }
        });
    }
}