package com.example.monsterhunterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton TrueToFake = (ImageButton) findViewById(R.id.true_to_fake);
        ImageButton FakeToTrue = (ImageButton) findViewById(R.id.fake_to_true);

        FakeToTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoToFakeToTrue = new Intent(MainActivity.this, fake_to_true.class);
                startActivity(GoToFakeToTrue);
            }
        });
    }
}