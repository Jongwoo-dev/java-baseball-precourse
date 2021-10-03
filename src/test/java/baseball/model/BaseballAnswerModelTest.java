package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a","2","3232","asd"})
	void 야구게임_잘못된_정답_입력값_처리(String input) {
		assertThat(answer.compareAnswer(input)).extracting(result -> result.isError()).isEqualTo(true);
	}
}
