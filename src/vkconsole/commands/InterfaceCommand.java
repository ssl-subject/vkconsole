package vkconsole.commands;

public interface InterfaceCommand {

	public void run();
	public default boolean setParams(String s) {
		return true;
	}
}