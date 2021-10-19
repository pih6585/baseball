package dice.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class playerNumberTest {

	@Test
	@DisplayName("참가 인원을 생성한다.")
	public void createPlayerNumber() {
		PlayerNumber playerNumber = new PlayerNumber("2");

		assertThat(playerNumber).isEqualTo(new PlayerNumber("2"));
	}

	@Test
	@DisplayName("참가 인원이 빈값이면 예외가 발생된다.")
	public void checkEmpty() {
		assertThrows(IllegalArgumentException.class,
			() -> new PlayerNumber(""));
	}

	@Test
	@DisplayName("참가 인원이 null 이면 예외가 발생된다.")
	public void checkNull() {
		assertThrows(IllegalArgumentException.class,
			() -> new PlayerNumber(null));
	}

	@ParameterizedTest
	@DisplayName("참가 인원이 2~4명사이가 아니면 예외가 발생한다.")
	@CsvSource(value = {"1", "5"})
	public void checkRangeNumber(String number) {
		assertThrows(IllegalArgumentException.class,
			() -> new PlayerNumber(number));
	}

	@ParameterizedTest
	@DisplayName("참가 인원은 숫자가 아니면 예외가 발생한다.")
	@CsvSource(value = {"12!", "qw2", "ㅂㅁ"})
	public void checkMatchType(String number) {
		assertThrows(IllegalArgumentException.class,
			() -> new PlayerNumber(number));
	}

}