package org.jackfang.game.rps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.jackfang.game.rps.container.OptionsContainer;
import org.jackfang.game.rps.container.SimpleCircleOptionsContainer;
import org.jackfang.game.rps.judge.Judge;
import org.jackfang.game.rps.judge.SimpleJudge;
import org.jackfang.game.rps.player.Player;
import org.jackfang.game.rps.player.RobotPlayer;
import org.junit.Before;
import org.junit.Test;

public class RobotPlayerTest {
	private RPSGame game;
	private Judge judge;
	private Player robotPlayer;
	private Player robotPlayer2;
	private OptionsContainer container;
	
	@Before
	public void setUp(){
		this.container = new SimpleCircleOptionsContainer();
		this.judge = new SimpleJudge(container);
		this.robotPlayer = new RobotPlayer(container, "jack");
		this.robotPlayer2 = new RobotPlayer(container, "larry");
		this.game = new RPSGame(container, this.judge);
	}
	
	@Test
	public void shouldProvideValidOptionSeries(){
		OptionsContainer options = this.game.getOptions();
		for (int i = 0 ; i < 20 ; i++){
			String opt = this.robotPlayer.play();
			assertTrue("Robert should play a real card", options.hasOption(opt));
		}
	}
	
	@Test
	public void shouldPlayWithOtherRobot(){
		RPSGameResult r =  this.game.run(this.robotPlayer, this.robotPlayer2, 10);
		assertEquals("should run specifed times game",  r.getTimes(), 10);
	}
	
	@Test 
	public void shouldReturnZeroWhenPlaytheSameCard(){
		Player jack = new Player(){
			public String play() {
				return "Rock";
			}
			public String getName() {
				return "jack";
			}
		};
		Player larry = new Player(){
			public String play() {
				return "Rock";
			}

			public String getName() {
				return "larry";
			}
		};
		RPSGameResult r =  this.game.run(jack, larry, 10);
		assertEquals("should run specifed times game",  r.getTimes(), 10);
		assertEquals("should run specifed times game",  r.getTimes("jack"), 0);
		assertEquals("should run specifed times game",  r.getTimes("larry"), 0);
		

	}
	
	@Test
	public void shouldReturnCorrectly(){
		Player jack = new Player(){
			public String play() {
				return "Rock";
			}
			public String getName() {
				return "jack";
			}
		};
		Player larry = new Player(){
			public String play() {
				return "Paper";
			}

			public String getName() {
				return "larry";
			}
		};
		
		RPSGameResult r =  this.game.run(jack, larry, 10);
		assertEquals("should run specifed times game",  r.getTimes("jack"), 0);
		assertEquals("should run specifed times game",  r.getTimes("larry"), 10);
	}
	
	@Test
	public void shouldReturnCorrectly2(){
		Player jack = new Player(){
			public String play() {
				return "Rock";
			}
			public String getName() {
				return "jack";
			}
		};
		Player larry = new Player(){
			public String play() {
				return "Scissors";
			}

			public String getName() {
				return "larry";
			}
		};
		
		RPSGameResult r =  this.game.run(jack, larry, 10);
		assertEquals("should run specifed times game",  r.getTimes("jack"), 10);
		assertEquals("should run specifed times game",  r.getTimes("larry"), 0);
	}

}
