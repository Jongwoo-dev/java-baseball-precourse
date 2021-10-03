package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseballAnswerModelTest {

	private BaseballAnswerModel answer;

	@BeforeEach
	void setUp() {
		answer = new BaseballAnswerModel();
	}

	@Test
	void 야구게임_정답_생성_길이_검사() {
		assertThat(answer.makeAnswer())
		.hasSize(3);
	}

	@Test
	void 야구게임_정답_생성_값_유효성_검사() {
		assertThat(answer.makeAnswer()).allMatch(num -> num > 0 && num < 10);
	}
}
