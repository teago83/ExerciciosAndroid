package com.example.httpjokesapithingy;

import org.json.JSONException;
import org.json.JSONObject;

public class Converter {

    public Joke GetInfo (String End) {
        String JSON = APIConnection.GetJSONFromAPI(End);
        Joke Return = ParseJSON(JSON);
        return Return;
    }

    private Joke ParseJSON (String JSON) {

        try {
            Joke Joke = new Joke();

            JSONObject JSONObject = new JSONObject(JSON);

            //JSONObject CategoryObject = JSONObject.getJSONObject("category");
            //JSONObject TypeObject = JSONObject.getJSONObject("type");

            Joke.SetCategory(JSONObject.getString("category"));
            Joke.SetType(JSONObject.getString("type"));
            Joke.SetSetup(JSONObject.getString("setup"));
            Joke.SetDelivery(JSONObject.getString("delivery"));
            Joke.SetId(JSONObject.getString("id"));

            return Joke;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

}
