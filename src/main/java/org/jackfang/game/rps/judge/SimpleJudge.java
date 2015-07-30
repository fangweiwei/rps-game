package org.jackfang.game.rps.judge;

import org.jackfang.game.rps.container.OptionsContainer;

public class SimpleJudge implements Judge {
	
	private OptionsContainer oc;

	public SimpleJudge(OptionsContainer oc) {
		super();
		this.oc = oc;
	}

	public int judge(String opt1, String opt2) {
		return oc.checkResult(opt1, opt2);
	}

}
