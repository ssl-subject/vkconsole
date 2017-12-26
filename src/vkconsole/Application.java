package vkconsole;

import java.util.Scanner;

import vkconsole.commands.*;

public class Application {
	private static Api api;
	
	public static void main(String[] args) {
	
		System.out.println("go to https://oauth.vk.com/authorize?client_id=6311851&display=page&redirect_uri=https://oauth.vk.com/blank.html&scope=messages&response_type=token&v=5.69");
		
		
		@SuppressWarnings("resource")
		Scanner reader = new Scanner(System.in); 
		setApi(new Api());
		
		while(true) {
			System.out.print("> ");
			String n = reader.nextLine();
			if(SetTokenCommand.getAlias().equals(n)) {
				System.out.print("Input token: ");
				String token = reader.nextLine();
				new SetTokenCommand().write(token).init();
				
			} else if(DialogsCommand.getAlias().equals(n)) {
				new DialogsCommand().init();
			} else {
				System.out.println("Command not found.");
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//reader.close();
		
	}
	
	
	public static void setApi(Api a) {
		api = a;
	}
	public static void setToken(String t) {
		api = new Api(t);
	}
	public static Api getApi() {
		return api;
	}
}
