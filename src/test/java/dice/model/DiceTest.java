package dice.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DiceTest {

	@Test
	@DisplayName("주사위를 생성한다.")
	public void createDice() {
		Dice dice = new Dice(4);

		assertThat(dice).isEqualTo(new Dice(4));
	}

	@ParameterizedTest
	@DisplayName("주사위는 1~6이 아니면 예외가 발생한다.")
	@CsvSource(value = {"0", "7"})
	public void checkRange(int number) {
		assertThrows(IllegalArgumentException.class,
			() -> new Dice(number));
	}

}