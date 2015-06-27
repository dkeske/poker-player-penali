package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {
	
	public JsonElement json = new JsonParser().parse("{\"key1\": \"value1\", \"key2\": \"value2\"}");

    static final String VERSION = "We will win. Some. We will.";

    public static int betRequest(JsonElement request) {

    	JsonObject object = request.getAsJsonObject();
    	String buy_in = object.get("current_buy_in").toString();
    	
        return Integer.parseInt(buy_in)+200;

    }

    public static void showdown(JsonElement game) {
    }
}
