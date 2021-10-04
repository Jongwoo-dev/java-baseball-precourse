package baseball.view;

import baseball.model.BaseballCompareResultVO;

public class BaseballView {
	
	public void printMessageInputAnswer() {
		System.out.print("숫자를 입력해주세요 : ");
	}
	
	public void printLineResult(BaseballCompareResultVO result) {
		if (result.isError()) {
			System.out.println("[ERROR] 입력값이 잘못되었습니다.");
			return;
		}
		System.out.println(result);
		if (result.isCorrectAnswer()) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
		}
	}
}
