package baseball.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class BaseballAnswerModel {
	private Set<Integer> answer;

	/* Constructor */
	public BaseballAnswerModel() {
		this.makeAnswer();
	}

	/* Getter, Setter */
	public Set<Integer> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<Integer> answer) {
		this.answer = answer;
	}

	/* Logic */
	/**
	 * 야구게임 정답 생성
	 */
	private void makeAnswer() {
		answer = new LinkedHashSet<>();
		do {
			answer.add(Randoms.pickNumberInRange(1, 9));
		} while(answer.size() < 3);
	}
	
	/**
	 * 입력값과 정답의 비교
	 * @param input 정답 입력값
	 * @return 비교 결과 객체 반환
	 */
	public BaseballCompareResultVO compareAnswer(String input) {
		if (!verifyAnswer(input)) {
			return new BaseballCompareResultVO(true);
		}
		//TODO 정답 입력값 비교 로직 구현
		return new BaseballCompareResultVO(0, 0);
	}
	
	/**
	 * 야구게임 정답 입력값 유효성 검사
	 * @param input 정답 입력값
	 * @return 올바른 입력값이면 true, 아니면 false
	 */
	private boolean verifyAnswer(String input) {
		if (input == null || input.length() != 3 || checkForDuplicateChar(input)) {
			return false;
		}
		try {
			Integer.parseInt(input);
		} catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	/**
	 * 입력값중 중복된 문자가 있는지 체크
	 * @param input 정답 입력값
	 * @return 중복된 문자가 있으면 true, 없으면 false
	 */
	private boolean checkForDuplicateChar(String input) {
		Set<String> strSet = new HashSet<>(Arrays.asList(input.split("")));
		return strSet.size() != input.length();
	}
}
