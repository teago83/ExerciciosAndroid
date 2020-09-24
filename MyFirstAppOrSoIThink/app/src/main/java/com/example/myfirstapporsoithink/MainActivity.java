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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Transição para a segunda tela
        Button TransitionButton = (Button) findViewById(R.id.SecondScreenButton);
        TransitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent IntentUe = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(IntentUe);
            }
        });

        //Ato de manter-se na primeira tela
        Button NenButton = (Button) findViewById(R.id.Nen);
        NenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FicarNaPrimeiraTela(v);
            }
        });
    }

    public void FicarNaPrimeiraTela(View v){
        AlertDialog.Builder Alerta = new AlertDialog.Builder(this);
        Alerta.setTitle("pergunta fundamental");
        Alerta.setMessage("ae, vc n queria ir pra sigunda tela de novo, ou quiria!!!???? >:(");
        Alerta.setPositiveButton("nao maluco", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "acho bao", Toast.LENGTH_SHORT).show();
            }
        });
        Alerta.setNegativeButton("claro q nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "to di oio ein ¬¬", Toast.LENGTH_SHORT).show();
            }
        });
        Alerta.create().show();
    }
}