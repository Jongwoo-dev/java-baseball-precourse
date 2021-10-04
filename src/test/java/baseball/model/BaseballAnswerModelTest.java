package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class BaseballAnswerModelTest {

	private BaseballAnswerModel answer;

	@BeforeEach
	void setUp() {
		answer = new BaseballAnswerModel();
	}

	@Test
	void 야구게임_정답_생성_길이_검사() {
		assertThat(answer.getAnswer())
				.hasSize(3);
	}

	@Test
	void 야구게임_정답_생성_값_유효성_검사() {
		assertThat(answer.getAnswer()).allMatch(num -> num > 0 && num < 10);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"a","2","3214","asd", "223"})
	void 야구게임_잘못된_정답_입력값_처리(String input) {
		assertThat(answer.compareAnswer(input)).extracting(result -> result.isError()).isEqualTo(true);
	}
	
	@ParameterizedTest
	@CsvSource(value = {"123:1:0","456:0:0","789:2:0","981:1:2","189:3:0"}, delimiter = ':')
	void 야구게임_정답_입력값과_정답의_비교(String input, int strike, int ball) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
					.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
					.thenReturn(1, 8, 9);
			BaseballAnswerModel answer = new BaseballAnswerModel();
			assertThat(answer.compareAnswer(input))
					.extracting(result -> result.equals(new BaseballCompareResultVO(strike, ball)))
					.isEqualTo(true);
		}
	}
}
