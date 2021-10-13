package dice.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class playerNumberTest {

	@Test
	@DisplayName("참가 인원을 생성한다.")
	public void createPlayerNumber() {
		PlayerNumber playerNumber = new PlayerNumber(2);

		assertThat(playerNumber).isEqualTo(new PlayerNumber(2));
	}

}