package dice.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class playStatusTest {

	@Test
	@DisplayName("플레이 정보를 알수 있다.")
	public void createPlayStatus() {
		PlayStatus playStatus = new PlayStatus(new Name("pih"), Arrays.asList(new Dice(3), new Dice(2)));

		assertThat(playStatus).isEqualTo(new PlayStatus(new Name("pih"), Arrays.asList(new Dice(3), new Dice(2))));
	}

	@Test
	@DisplayName("플레이 주사위 합을 알수 있다.")
	public void findTotalDiceNumber() {
		PlayStatus playStatus = new PlayStatus(new Name("pih"), Arrays.asList(new Dice(3), new Dice(2)));

		assertThat(playStatus.findTotalNumber()).isEqualTo(5);
	}
}