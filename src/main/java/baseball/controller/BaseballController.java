package baseball.controller;

import baseball.model.BaseballAnswerModel;
import baseball.model.BaseballCompareResultVO;
import baseball.view.BaseballView;
import nextstep.utils.Console;

public class BaseballController {
	private BaseballView view = new BaseballView();
	
	/**
	 * 프로그램 시작
	 */
	public void run() {
		do {
			gameStart();
		} while("1".equals(getInputRestart()));
	}
	
	/**
	 * 재시작 여부 받아오기
	 * @return "1" 또는 "2"
	 */
	private String getInputRestart() {
		String input = "";
		do {
			view.printLineRestartQuestion();
			input = Console.readLine();
		} while(!"1".equals(input) && !"2".equals(input));
		return input;
	}
	
	/**
	 * 야구게임 시작(단판)
	 */
	private void gameStart() {
		BaseballAnswerModel answer = new BaseballAnswerModel();
		boolean endGame = false;
		do {
			String userInput = getInputAnswer();
			BaseballCompareResultVO result = answer.compareAnswer(userInput);
			view.printLineResult(result);
			endGame = result.isCorrectAnswer();
		} while(!endGame);
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
