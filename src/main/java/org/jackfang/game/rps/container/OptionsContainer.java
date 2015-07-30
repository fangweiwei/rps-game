package org.jackfang.game.rps.container;

public interface OptionsContainer {

	public void addOption(String opt);

	public int  size();

	public boolean hasOption(String opt);

	public int checkResult(String opt1, String opt2);

	public String getOption(int index);

}
