package org.jackfang.game.rps;

import org.jackfang.game.rps.container.OptionsContainer;
import org.jackfang.game.rps.judge.Judge;
import org.jackfang.game.rps.player.HumanPlayer;
import org.jackfang.game.rps.player.Player;
import org.jackfang.game.rps.player.RobotPlayer;


public class RPSGame {
	
	private OptionsContainer oc;
	private Judge judge;
	
	public RPSGame(){
	}

	public RPSGame(OptionsContainer oc, Judge judge) {
		this.oc = oc;
		this.judge = judge;
	}

	public OptionsContainer getOc() {
		return oc;
	}

	public void setOc(OptionsContainer oc) {
		this.oc = oc;
	}

	public Judge getJudge() {
		return judge;
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}

	public OptionsContainer getOptions() {
		return this.oc;
	}

	public int run(Player player, Player player2) {
		String opt1 = player.play();
		String opt2 = player2.play();
		System.out.print(String.format("%s played %s vs %s played %s ", player.getName(), opt1, player2.getName(), opt2));
		return this.judge.judge(opt1, opt2);
	}
	
	public RPSGameResult run(Player robotPlayer, Player robotPlayer2, int times) {
		if (times < 1) throw new IllegalArgumentException();
		RPSGameResult result = new RPSGameResult(times);
		for(int i = 0; i < times; i++){
			int r = this.run(robotPlayer, robotPlayer2);
			if (r == 1){
				result.incrementOne(robotPlayer.getName());
				System.out.println(String.format("and %s won.", robotPlayer.getName()));
			}else if (r == -1){
				result.incrementOne(robotPlayer2.getName());
				System.out.println(String.format("and %s won.", robotPlayer2.getName()));
			}else{
				System.out.println("No one won");
			}
		}
		return result;
	}

	public void robot2robot(RobotPlayer robotPlayer, RobotPlayer robotPlayer2) {
		RPSGameResult r =  this.run(robotPlayer, robotPlayer2, 1);
	}

	public void human2robot(RobotPlayer robotPlayer, HumanPlayer robotPlayer2) {
		RPSGameResult r =  this.run(robotPlayer, robotPlayer2, 1);
	}

}
