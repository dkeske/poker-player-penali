package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {

	public JsonElement json = new JsonParser()
			.parse("{\"key1\": \"value1\", \"key2\": \"value2\"}");

	static final String VERSION = "We will win. Some. We will.";

	public static int betRequest(JsonElement request) {
		int i;
		int raise = 0;
		int counter = 0;
		JsonObject object = request.getAsJsonObject();
		String buy_in = object.get("current_buy_in").toString();
		JsonArray jarray = object.getAsJsonArray("players");
		JsonArray cards = object.getAsJsonArray("community_cards");

		// System.out.println();
		// System.out.println("POCETAK");
		// System.out.println(jarray.get(0).getAsJsonObject().get("hole_cards").getAsJsonArray().get(0).getAsJsonObject().get("rank").toString());
		for (i=0; i < jarray.size(); i++) {
			if (jarray.get(i).getAsJsonObject().get("name").toString()
					.toLowerCase() == "penali") {
				System.out.println("Help me world");
				JsonArray karte = jarray.get(i).getAsJsonObject()
						.get("hole_cards").getAsJsonArray();
				for (int j = 0; j < cards.size(); j++) {
					if (karte
							.get(i)
							.getAsJsonObject()
							.get("rank")
							.toString()
							.equals(cards.get(j).getAsJsonObject().get("rank")
									.toString())){
//							|| karte.get(i)
//									.getAsJsonObject()
//									.get("suit")
//									.toString()
//									.equals(cards.get(j).getAsJsonObject()
//											.get("suit").toString())) {
						counter++;
						System.out.println("WIN :)");
						//return Integer.parseInt(buy_in) + 200;
					} else {
						//return Integer.parseInt(buy_in);
					}
				}
				switch (counter) {
				case 4: return jarray.get(i).getAsJsonObject().get("stack").getAsInt() ;
				case 3: return Integer.parseInt(buy_in)+ 200;
				case 2: return Integer.parseInt(buy_in)+100;
				default:
					return Integer.parseInt(buy_in)-jarray.get(1).getAsJsonObject().get(
							"bet").getAsInt();
				}
				
			}
		}
		return 0;

	}

	public static void showdown(JsonElement game) {
	}
}
