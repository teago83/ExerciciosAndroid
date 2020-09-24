package com.example.myfirstapporsoithink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText InputNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputNome = findViewById(R.id.YourName);
        Button TransitionButton = (Button) findViewById(R.id.SecondScreenButton);
        TransitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                String nome = InputNome.getText().toString();

                Intent IntentUe = new Intent(MainActivity.this, SecondActivity.class);

                IntentUe.putExtra("Nome", nome);
                startActivity(IntentUe);
                finish();
            }
        });
    }
}