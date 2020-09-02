package com.example.primeiroprojetofacelho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disable (View v)
    {
        //Log.d("success","Button successfully disabled!");

        /*View myView = findViewById(R.id.button01);
        View mySecondView = findViewById(R.id.button02);
        myView.setEnabled(false);
        mySecondView.setArrozComCarne("false");
        Button button = (Button) myView;
        button.setText("New Disabled");

        if (mySecondView.arrozComCarne == "false")
        {

        }


        v.setEnabled(false);
        Button b = (Button) v;
        b.setText("Disabled");
        */
    }
}

