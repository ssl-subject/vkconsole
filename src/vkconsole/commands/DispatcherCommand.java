package vkconsole.commands;

import java.util.HashMap;
import java.util.Map;

public class DispatcherCommand {
	private Map<String,InterfaceCommand> data = new HashMap<>();
	
	public DispatcherCommand add(String alias, InterfaceCommand cmd) {
		data.put(alias, cmd);
		return this;
	}
	
	public boolean execute(String string) {
		String[] params = string.split(" ", 2);
		InterfaceCommand command = data.get(params[0]);
		if(command != null) {
			
			if(command.setParams( (params.length >= 2 ? params[1] : null) )) {
				command.run();
			}

			return true;
		} 
		return false;
	}
}
