package com.grupogo.mvvmtemplateapp.data.server;

import com.grupogo.mvvmtemplateapp.model.datamodel.Item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorge_cmata on 17/10/17.
 */

public class JSONParseHelper {

    public static List<Item> parseResponse(String responseString) throws JSONException {
        List<Item> itemList = new ArrayList<>();
        JSONObject responseJSON = new JSONObject(responseString);
        JSONArray itemListJSONArray = responseJSON.getJSONArray("drinks");
        for (int i = 0; i < itemListJSONArray.length(); i++) {
            JSONObject jsonobject = itemListJSONArray.getJSONObject(i);
            itemList.add(new Item(jsonobject.getString("strDrink")));
        }
        return itemList;
    }
}
