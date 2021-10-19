package dice.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayResultTest {

	@Test
	@DisplayName("게임 결과를 생성한다.")
	public void createGameResult() {
		PlayResult playResult = new PlayResult(getPlayStatus());

		assertThat(playResult).isEqualTo(new PlayResult(getPlayStatus()));
	}

	@Test
	@DisplayName("게임의 제일 높은 점수를 알 수 있다.")
	public void findHighScore() {
		PlayResult playResult = new PlayResult(getPlayStatus());

		assertThat(playResult.findHighScore()).isEqualTo(8);
	}

	@Test
	@DisplayName("게임의 우승자를 알 수 있다.")
	public void findWinners() {
		PlayResult playResult = new PlayResult(getPlayStatus());

		assertThat(playResult.findWinners()).containsExactly(new Name("lee"));
	}

	private List<PlayStatus> getPlayStatus() {
		List<PlayStatus> playResults = new ArrayList<>();
		PlayStatus playStatus1 = new PlayStatus(new Name("pih"), Arrays.asList(new Dice(3), new Dice(2)));
		PlayStatus playStatus2 = new PlayStatus(new Name("kim"), Arrays.asList(new Dice(1), new Dice(5)));
		PlayStatus playStatus3 = new PlayStatus(new Name("lee"), Arrays.asList(new Dice(4), new Dice(4)));
		playResults.add(playStatus1);
		playResults.add(playStatus2);
		playResults.add(playStatus3);
		return playResults;
	}

}