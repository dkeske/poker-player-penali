package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {

    static final String VERSION = "We will win. Some. We will.";

    public static int betRequest(JsonElement request) {
    	int raise=0;
    	JsonObject object = request.getAsJsonObject();
    	String buy_in = object.get("current_buy_in").toString();
    	
    	JsonArray jarray = object.getAsJsonArray("players");
    	for (int i = 0; i < jarray.size(); i++) {
			if(jarray.get(i).getAsJsonObject().get("name").toString().toLowerCase().equals("penali")){
				JsonArray karte = jarray.get(i).getAsJsonObject().get("hole_cards").getAsJsonArray();
				if (karte.get(0).getAsJsonObject().get("rank").toString().equals(karte.get(1).getAsJsonObject().get("rank").toString()) || 
					karte.get(0).getAsJsonObject().get("suit").toString().equals(karte.get(1).getAsJsonObject().get("suit").toString())){
						return Integer.parseInt(buy_in)+200; 
					} else {
						return 0;
					}
			}
		}
    	return 0;
        
    }

    public static void showdown(JsonElement game) {
    }
}
