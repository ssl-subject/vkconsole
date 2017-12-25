package vkconsole.methods;

import vkconsole.Application;

public class Users {
	
	public static void get(String user_ids) {
		get(user_ids, "first_name,last_name,uid");
	}
	
	public static void get(String user_ids, String fields) {
		Application.getApi().get("Users.get?user_ids=" + user_ids + "&fields=" + fields);
		
	}
}
