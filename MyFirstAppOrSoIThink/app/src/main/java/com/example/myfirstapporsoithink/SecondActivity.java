package com.example.myfirstapporsoithink;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Transição para a primeira tela
        Button TransitionButton = (Button) findViewById(R.id.MainScreenButton);
        TransitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentUe = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(IntentUe);
            }
        });

        //Ato de manter-se na segunda tela
        Button NenButton = (Button) findViewById(R.id.Nen);
        NenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FicarNaSegundaTela(v);
            }
        });
    }

    public void FicarNaSegundaTela(View v){
        AlertDialog.Builder Alerta = new AlertDialog.Builder(this);
        Alerta.setTitle("pergunta mto importante");
        Alerta.setMessage("ae, tu n quer ir pra primeira tela de novo, neh????");
        Alerta.setPositiveButton("nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "imaginei msm", Toast.LENGTH_SHORT).show();
            }
        });
        Alerta.setNegativeButton("outro nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(SecondActivity.this, "po, concordo plenament", Toast.LENGTH_SHORT).show();
            }
        });
        Alerta.create().show();
    }
}