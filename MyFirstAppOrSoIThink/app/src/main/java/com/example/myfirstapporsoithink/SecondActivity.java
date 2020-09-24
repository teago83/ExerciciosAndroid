package com.example.myfirstapporsoithink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    private EditText InputSobrenome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        InputSobrenome = findViewById(R.id.YourLastName);
        Button TransitionButton = (Button) findViewById(R.id.MainScreenButton);
        TransitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                String sobrenome = InputSobrenome.getText().toString();

                Intent IntentUe = new Intent(SecondActivity.this, MainActivity.class);

                IntentUe.putExtra("Sobrenome", sobrenome);
                startActivity(IntentUe);
                finish();
            }
        });
    }
}