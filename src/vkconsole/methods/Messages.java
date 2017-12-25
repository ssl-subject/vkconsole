package vkconsole.methods;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import vkconsole.elements.Dialog;

public class Messages extends Method {
	
	public static Dialog[] getDialogs() {
		
		JsonArray ja = getApi().get("messages.getDialogs?count=100").get("response").getAsJsonArray();
		Dialog dialog[] = new Dialog[ja.get(0).getAsInt()];
		
		String searchUsers = "";
		for(int i = 1; i < ja.size(); i++) {
			dialog[i] = new Dialog();
			JsonObject jo = ja.get(i).getAsJsonObject();
			
		
			
			dialog[i].body = jo.get("body").getAsString();
			dialog[i].userId = jo.get("uid").getAsInt();
			
			
			
			if(jo.has("chat_id")) {
				dialog[i].isChat = true;
				dialog[i].chatId = jo.get("chat_id").getAsInt();
				dialog[i].title = jo.get("title").getAsString();
			} else {
				dialog[i].isChat = false;
				searchUsers += dialog[i].userId + ",";
			}
		}
		//Users.get(searchUsers);
		
		return dialog;
		
	}
}
