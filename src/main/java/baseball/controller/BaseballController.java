package baseball.controller;

import baseball.view.BaseballView;
import nextstep.utils.Console;

public class BaseballController {
	private BaseballView view = new BaseballView();
	
	/**
	 * 야구게임 시작
	 */
	public void gameStart() {
		do {
			String userAnswer = getInputAnswer();
			System.out.println("입력값 : " + userAnswer);
		} while(true);
	}
	
	/**
	 * 입력한 답변 받아오기
	 * @return 입력한 값
	 */
	private String getInputAnswer() {
		view.printMessageInputAnswer();
		return Console.readLine();
	}
}
