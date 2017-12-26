package vkconsole.commands;

import vkconsole.Application;

public class SetTokenCommand implements InterfaceCommand {
	private String token;
	
	public SetTokenCommand write(String s) {
		token = s;
		return this;
	}

	public void init() {
		Application.setToken(token);
		System.out.println("Token inited: "+ token);
	}
	
	public static String getAlias() {
		return "settoken";
	}

}
