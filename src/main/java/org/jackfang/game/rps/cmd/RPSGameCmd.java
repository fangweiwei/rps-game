package org.jackfang.game.rps.cmd;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import org.jackfang.game.rps.RPSGame;
import org.jackfang.game.rps.container.OptionsContainer;
import org.jackfang.game.rps.container.SimpleCircleOptionsContainer;
import org.jackfang.game.rps.judge.Judge;
import org.jackfang.game.rps.judge.SimpleJudge;
import org.jackfang.game.rps.player.HumanPlayer;
import org.jackfang.game.rps.player.RobotPlayer;

public class RPSGameCmd {

	public static void main(String[] args) throws IOException {
		OptionsContainer container = new SimpleCircleOptionsContainer();
		Judge judge = new SimpleJudge(container);
		RPSGame game = new RPSGame(container, judge);
		
		Properties prop = RPSGameCmd.getPropValues();
		System.out.println(prop.getProperty("gameWelcome"));
		
		Scanner s = new Scanner(System.in);
		RobotPlayer robotPlayer = new RobotPlayer(container, "ROBOT#1");
		RobotPlayer robotPlayer2 = new RobotPlayer(container, "ROBOT#2");
		HumanPlayer human = new HumanPlayer(container);
		
		
		while(true){
			System.out.println(prop.getProperty("gameRules"));
			String opt = s.nextLine();
			if (opt.equals("quit")){
				System.out.println(prop.getProperty("bye"));
				break;
			}
			if (opt.equals("1")) {
				System.out.println(prop.getProperty("robot2robot"));
				System.out.println(prop.getProperty("start_robot2robot"));
				s.nextLine();
				while(true){
					game.robot2robot(robotPlayer, robotPlayer2);
					System.out.println(prop.getProperty("askContinue"));
					String y = s.nextLine();
					if (y.startsWith("N") || y.startsWith("n")){
						System.out.println(prop.get("exit_robot2robot"));
						break;
					}
				}
			}else {
				System.out.println(prop.getProperty("human2robot"));
				while(true){
					game.human2robot(robotPlayer, human);
					System.out.println(prop.getProperty("askContinue"));
					String y = s.nextLine();
					if (!y.startsWith("Y") &&  !y.startsWith("y")){
						System.out.println(prop.get("exit_human2robot"));
						break;
					}
				}
			}
		}
		s.close();
	}

	private static Properties getPropValues() throws IOException {
		Properties prop = new Properties();
		InputStream inputStream = null;	
		try {
			String propFileName = "i18N.properties";
			inputStream = RPSGameCmd.class.getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			return prop;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			if(inputStream != null) inputStream.close();
		}
		return prop;
	}
}
