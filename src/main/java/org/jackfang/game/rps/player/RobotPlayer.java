package org.jackfang.game.rps.player;

import java.util.concurrent.ThreadLocalRandom;

import org.jackfang.game.rps.container.OptionsContainer;

public class RobotPlayer implements Player {
	
	private OptionsContainer container;
	private String name;

	public RobotPlayer(OptionsContainer container, String name) {
		this.container = container;
		this.name = name;
	}

	public String play() {
		int size = this.container.size();
		ThreadLocalRandom  random = ThreadLocalRandom.current();
		int i = random.nextInt(0, size);	
		return this.container.getOption(i);
	}

	public String getName() {
		return name;
	}

}
