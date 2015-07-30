package org.jackfang.game.rps.container;

import java.util.ArrayList;
import java.util.List;

public class SimpleCircleOptionsContainer implements OptionsContainer {
	
	private List<String> options = new ArrayList<String>(3);
	
	public SimpleCircleOptionsContainer(){
		this.options.add("Rock");
		this.options.add("Scissors");
		this.options.add("Paper");
	}
	
	public void addOption(String opt) {
		options.add(opt);
	}
	public int size() {
		return options.size();
	}
	public boolean hasOption(String opt) {
		return options.contains(opt);
	}
	
	public int checkResult(String opt1, String opt2) {
		int index1 = this.options.indexOf(opt1);
		int index2 = this.options.indexOf(opt2);
		int n = options.size();
		if (((index1 + 1) % n ) == index2){
			return 1;
		}
		if (((index2 + 1) % n ) == index1){
			return -1;
		}
		return 0;
	}

	public String getOption(int index) {
		return this.options.get(index);
	}
}
