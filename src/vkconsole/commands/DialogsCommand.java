package vkconsole.commands;

import vkconsole.commands.InterfaceCommand;
import vkconsole.methods.Messages;

public class DialogsCommand implements InterfaceCommand {
	public static String getAlias() {
		return "dialogs";
	}

	@Override
	public void init() {
		Messages.getDialogs();
	}
	
}
