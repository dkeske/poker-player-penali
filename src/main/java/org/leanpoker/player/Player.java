package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {

	static final String VERSION = "We will win. Some. We will.";

	public static int betRequest(JsonElement request) {
		
		
		int i;
		int raise = 0;
		int counter = 1;
		JsonObject object = request.getAsJsonObject();
		String buy_in = object.get("current_buy_in").toString();
		JsonArray jarray = object.getAsJsonArray("players");
		JsonArray cards = object.getAsJsonArray("community_cards");
		JsonArray karte = jarray.get(1).getAsJsonObject().get("hole_cards")
				.getAsJsonArray();
		if (cards.size() > 0) {
			for (i = 0; i < karte.size(); i++) {

				for (int j = 0; j < cards.size(); j++) {
					if (karte
							.get(i)
							.getAsJsonObject()
							.get("rank")
							.toString()
							.equals(cards.get(j).getAsJsonObject().get("rank")
									.toString())) {

						counter++;
						System.out.println("WIN :)");
					}

				}
			}
			switch (counter) {
			case 4:
				return jarray.get(i).getAsJsonObject().get("stack").getAsInt();
			case 3:
				return Integer.parseInt(buy_in) + 200;
			case 2:
				return Integer.parseInt(buy_in)
						- jarray.get(1).getAsJsonObject().get("bet").getAsInt();
			default:
				return 0;

			}
		} else {
			if (karte
					.get(0)
					.getAsJsonObject()
					.get("rank")
					.toString()
					.equals(karte.get(1).getAsJsonObject().get("rank")
							.toString())
					|| karte.get(0)
							.getAsJsonObject()
							.get("suit")
							.toString()
							.equals(karte.get(1).getAsJsonObject().get("suit")
<<<<<<< HEAD
									.toString())) {
				return Integer.parseInt(buy_in) + 200;
			}else if (karte
					.get(0)
					.getAsJsonObject()
					.get("rank")
					.toString()
					.matches("^[JKDA]|[1][0]$")
					|| karte
					.get(1)
					.getAsJsonObject()
					.get("rank")
					.toString()
					.matches("^[JKDA]|[1][0]$")) {
				return Integer.parseInt(buy_in) + 100;
				
			}
			else {
				return Integer.parseInt(buy_in)
						- jarray.get(1).getAsJsonObject().get("bet").getAsInt();
			}
		}
=======
									.toString())){
				System.out.println("PAR U RUCI");
				return Integer.parseInt(buy_in)+ 200;
			}
		}
	return Integer.parseInt(buy_in)-jarray.get(1).getAsJsonObject().get(
			"bet").getAsInt();
>>>>>>> origin/master

	}

	public static void showdown(JsonElement game) {
	}
}
