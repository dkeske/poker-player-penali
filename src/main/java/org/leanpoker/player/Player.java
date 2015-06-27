package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.Map;

public class Player {
	
	public JsonElement json = new JsonParser().parse("{\"key1\": \"value1\", \"key2\": \"value2\"}");

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {
    		
        return 200;
    }

    public static void showdown(JsonElement game) {
    }
}
