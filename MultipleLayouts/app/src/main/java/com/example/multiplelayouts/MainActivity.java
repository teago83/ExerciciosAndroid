package com.example.multiplelayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button WryyyButton = (Button) findViewById(R.id.teladois);
        WryyyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoadSecondScreen = new Intent (MainActivity.this, MainActivity2.class);
                startActivity(LoadSecondScreen);
            }
        });

    }
}