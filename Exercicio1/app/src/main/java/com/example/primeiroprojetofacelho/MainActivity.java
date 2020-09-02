package com.example.primeiroprojetofacelho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    int arroz = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void disable (View v)
    {
        String batata = "";

        if (arroz == 0)
        {
            batata = "Disabled";
        }
        if (arroz == 1)
        {
            batata = "Or is it?";
        }

        v.setEnabled(false);
        Button b = (Button) v;
        b.setText(batata);

        arroz = arroz + 1;

        //Log.d("success","Button successfully disabled!");

        /* View myView = findViewById(R.id.button01);
        myView.setEnabled(false);
        Button button01 = (Button) myView;
        button01.setText("New Disabled"); */

        /* A way of doing all of this 'assigning' thing is by creating a View object,
        assigning it to a Button object, and then doing whatever you'd like to (such as
        setting the button's text to 'new disabled', as you just did). Also, the 'find
        -ViewById' function is quite useful, so try not to forget about it. */

    }
}

