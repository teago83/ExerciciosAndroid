package com.example.httpjokesapithingy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView Category;
    private TextView Type;
    private TextView Setup;
    private TextView Delivery;
    private TextView Id;

    private TextView NSFW;
    private TextView Religious;
    private TextView Political;
    private TextView Racist;
    private TextView Sexist;

    private ProgressDialog Load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadJoke Download = new DownloadJoke();

        Category = (TextView)findViewById(R.id.category);
        Type = (TextView)findViewById(R.id.type);
        Setup = (TextView)findViewById(R.id.setup);
        Delivery = (TextView)findViewById(R.id.delivery);
        Id = (TextView)findViewById(R.id.id);

        NSFW = (TextView)findViewById(R.id.nsfw);
        Religious = (TextView)findViewById(R.id.religious);
        Political = (TextView)findViewById(R.id.political);
        Racist = (TextView)findViewById(R.id.racist);
        Sexist = (TextView)findViewById(R.id.sexist);

        Download.execute();
    }

    private class DownloadJoke extends AsyncTask<Void, Void, Joke> {

        @Override
        protected void onPreExecute() {
            Load = ProgressDialog.show(MainActivity.this,
                    "Please, wait...", "Obtaining info...");
        }

        @Override
        protected Joke doInBackground(Void... voids) {
            Converter Converter = new Converter();
            return Converter.GetInfo("https://sv443.net/jokeapi/v2/joke/Any?type=twopart");
        }

        @Override
        protected void onPostExecute (Joke Joke) {
            Category.setText(Joke.GetCategory().substring(0,1).toUpperCase()+Joke.GetCategory().substring(1));
            Type.setText(Joke.GetType().substring(0,1).toUpperCase()+Joke.GetType().substring(1));
            Setup.setText(Joke.GetSetup().substring(0,1).toUpperCase()+Joke.GetSetup().substring(1));
            Delivery.setText(Joke.GetDelivery().substring(0,1).toUpperCase()+Joke.GetDelivery().substring(1));
            Id.setText(Joke.GetId().substring(0,1).toUpperCase()+Joke.GetId().substring(1));

            Load.dismiss();
        }
    }
}