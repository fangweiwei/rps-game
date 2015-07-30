package org.jackfang.game.rps;

import java.util.HashMap;
import java.util.Map;

public class RPSGameResult {
	private Map<String, Integer> scores = new HashMap<String, Integer>(2);
	private int times;
	public RPSGameResult(int times) {
		super();
		this.times = times;
	}
	public void incrementOne(String player) {
		Integer score = this.scores.get(player);
		if (score == null) {
			score = 0;
		}
		score++;
		this.scores.put(player, score);
	}
	public void report() {
		System.out.println(String.format("Total %s rounds", this.times));
		for(Map.Entry<String,Integer> player : this.scores.entrySet()){
			String name = player.getKey();
			Integer score = player.getValue();
			if (score == null) {
				score = 0;
			}
			System.out.println(String.format("%s win %s times", name, score));
		}
	}
	
	public int getTimes(){
		return this.times;
	}
	
	public int getTimes(String player){
		Integer score = this.scores.get(player);
		if (score == null) {
			score = 0;
		}
		return score;
	}

}
