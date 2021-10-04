package baseball.controller;

import baseball.model.BaseballAnswerModel;
import baseball.model.BaseballCompareResultVO;
import baseball.view.BaseballView;
import nextstep.utils.Console;

public class BaseballController {
	private BaseballView view = new BaseballView();
	
	/**
	 * 야구게임 시작
	 */
	public void gameStart() {
		BaseballAnswerModel answer = new BaseballAnswerModel();
		do {
			String userInput = getInputAnswer();
			System.out.println("입력값 : " + userInput);
			BaseballCompareResultVO result = answer.compareAnswer(userInput);
			System.out.println("비교 결과 : " + result);
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
