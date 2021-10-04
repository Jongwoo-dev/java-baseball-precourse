package baseball.controller;

import baseball.model.BaseballAnswerModel;
import baseball.model.BaseballCompareResultVO;
import baseball.view.BaseballView;
import nextstep.utils.Console;

public class BaseballController {
	private BaseballView view = new BaseballView();
	
	/**
	 * 야구게임 시작(단판)
	 */
	public void gameStart() {
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
