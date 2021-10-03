package baseball.model;

import java.util.LinkedHashSet;
import java.util.Set;

import nextstep.utils.Randoms;

public class BaseballAnswerModel {
	private Set<Integer> answer;

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
	 * @return 서로다른 랜덤한 한자리 숫자 3개를 가지는 Set
	 */
	public Set<Integer> makeAnswer() {
		answer = new LinkedHashSet<>();
		do {
			answer.add(Randoms.pickNumberInRange(1, 9));
		} while(answer.size() < 3);
		return answer;
	}
}
