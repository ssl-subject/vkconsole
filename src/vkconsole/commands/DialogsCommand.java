package vkconsole.commands;

import vkconsole.commands.InterfaceCommand;
import vkconsole.methods.Messages;

public class DialogsCommand implements InterfaceCommand {

	@Override
	public void run() {
		Messages.getDialogs();
	}
	
}
