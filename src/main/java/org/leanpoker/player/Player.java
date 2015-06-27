package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {

	public JsonElement json = new JsonParser().parse("{\"key1\": \"value1\", \"key2\": \"value2\"}");

	static final String VERSION = "We will win. Some. We will.";

	public static int betRequest(JsonElement request) {

		int raise=0;
		JsonObject object = request.getAsJsonObject();
		System.out.println(request);
		String buy_in = object.get("current_buy_in").toString();
		JsonArray jarray = object.getAsJsonArray("players");
		System.out.println();
		System.out.println("POCETAK");
		System.out.println(jarray.get(1).toString());


		System.out.println("Help me world");
		JsonArray karte = jarray.get(1).getAsJsonObject().get("hole_cards").getAsJsonArray();
		if (karte.get(0).getAsJsonObject().get("rank").toString().equals(karte.get(1).getAsJsonObject().get("rank").toString()) || 
				karte.get(0).getAsJsonObject().get("suit").toString().equals(karte.get(1).getAsJsonObject().get("suit").toString())){
			System.out.println("Hello world :)");
			return Integer.parseInt(buy_in)+200; 
		} else {
			return Integer.parseInt(buy_in)+100;
		}





	}

	public static void showdown(JsonElement game) {
	}
}
