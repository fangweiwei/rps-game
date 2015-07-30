package org.jackfang.game.rps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jackfang.game.rps.container.OptionsContainer;
import org.jackfang.game.rps.container.SimpleCircleOptionsContainer;
import org.jackfang.game.rps.judge.Judge;
import org.jackfang.game.rps.judge.SimpleJudge;
import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class SimpleCircleOptionsContainerTest 
{
	private RPSGame game;
	private Judge judge;
	
	@Before
	public void setUp(){
		OptionsContainer container = new SimpleCircleOptionsContainer();
		this.judge = new SimpleJudge(container);
		this.game = new RPSGame(container, this.judge);
	}
	
	@Test
	public void shouldCreateGameCorrectly(){
		OptionsContainer options = this.game.getOptions();
		assertEquals("RPS game should have three options in the RPS game", options.size(), 3);
		
		assertTrue("RPS game should contains option Rock", options.hasOption("Rock"));
		assertTrue("RPS game should contains option Paper", options.hasOption("Paper"));
		assertTrue("RPS game should contains option Scissors", options.hasOption("Scissors"));
		
		assertEquals("The first one should be Rock", options.getOption(0), "Rock");
		assertEquals("The second one should be Rock", options.getOption(1), "Scissors");
		assertEquals("The third one should be Rock", options.getOption(2), "Paper");
	}
	
}
