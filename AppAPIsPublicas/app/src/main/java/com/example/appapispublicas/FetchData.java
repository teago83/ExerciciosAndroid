package com.example.appapispublicas;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void, Void, Void> {

    String json_data;
    String ParsedData;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL linkComJSON = new URL ("https://sv443.net/jokeapi/v2/joke/Any");
            HttpURLConnection Connection = (HttpURLConnection) linkComJSON.openConnection();
            InputStream IStream = Connection.getInputStream();
            BufferedReader BuffReader = new BufferedReader(new InputStreamReader(IStream));

            // all of these little items contribute to enabling the app to read the data

            String line = "";

            while(line != null){
                line = BuffReader.readLine();
                json_data = json_data + line;
            }

            JSONArray JSON = new JSONArray(json_data);

            JSONObject JO = (JSONObject) JSON.get(0);
            ParsedData = "Error:" + JO.get("error") + "\n" +
                         "Category:" + JO.get("category") + "\n" +
                         "Type:" + JO.get("type") + "\n" +
                         "Joke:" + JO.get("joke") + "\n" +
                         "Flags:" + JO.get("flags") + "\n" +
                         "ID:" + JO.get("id") + "\n" +
                         "Lang:" + JO.get("lang") + "\n";


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    // the UI can be modified here, but not in the 'doInBackground' function
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.data.setText(this.json_data);
    }
}

// JSON source: https://sv443.net/jokeapi/v2/joke/Any