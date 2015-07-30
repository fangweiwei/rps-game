package org.jackfang.game.rps.player;

import java.util.Scanner;

import org.jackfang.game.rps.container.OptionsContainer;
import org.jackfang.game.rps.container.SimpleCircleOptionsContainer;

public class HumanPlayer implements Player {
	
	private OptionsContainer container;
	private String name;
	private Scanner s = new Scanner(System.in);

	public HumanPlayer(OptionsContainer container) {
		this.container = container;
	}

	public void start(){
		System.out.print("Before game start, please input your name: ");
		this.name = s.nextLine();
		System.out.println(String.format("Hey %s, welcome to this fun game! ", this.name));
		System.out.println("Options you can choose are: Rock Paper Scissors.");
		System.out.println();
	}
	
	public String play() {
		if (this.name == null) {
			this.start();
		}
		
		System.out.print("Please input you choice :  ");
		String opt = this.s.nextLine();
		while (! this.container.hasOption(opt)){
			System.out.print("Wrong option! Please input you choice again :  ");
			opt = this.s.nextLine();
		}
		return opt;
	}

	public String getName() {
		return this.name;
	}

	public static void main(String [] args){
		OptionsContainer container = new SimpleCircleOptionsContainer();
		HumanPlayer p = new HumanPlayer(container);
		p.start();
		p.play();
		
	}
}
