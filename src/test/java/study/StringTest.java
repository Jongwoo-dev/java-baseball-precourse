package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	void 문자열_분리_테스트() {
		assertThat("1,2".split(","))
		.contains("1")
		.contains("2")
		.containsExactly("1","2")
		;
	}

	@Test
	void 부분문자열_테스트() {
		assertThat("(1,2)".substring(1, 4))
		.isEqualTo("1,2")
		;
	}

	@Test
	@DisplayName("특정위치의 문자를 가져오고, 예외발생을 확인한다")
	void 특정위치의_문자_가져오기() {
		assertThat("abc".charAt(1))
		.isEqualTo('b')
		;

		assertThatThrownBy(() -> {
			"abc".charAt(3);
		}).isInstanceOf(IndexOutOfBoundsException.class)
		.hasMessageContaining("String index out of range: 3");

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
		.isThrownBy(() -> {
			"abc".charAt(3);
		}).withMessageMatching("String index out of range: \\d+");

	}
}
