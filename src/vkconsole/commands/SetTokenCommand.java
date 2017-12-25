package vkconsole.commands;

import java.util.Scanner;

import vkconsole.Application;

public class SetTokenCommand implements InterfaceCommand {
	private String token;
	
	public boolean setParams(String token) {
		if(token == null) {
			System.out.println("settoken [token]");
			return false; 
		}
		this.token = token;
		return true;
	}
	public void run() {
		
		Application.setToken(token);
		System.out.println("Token inited: "+ token);
	}
	
}
