package model;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

	public static final int INITIAL_PRIZE_COUNT = 0;
	private Map<Status, Integer> result;

	@BeforeEach
	void setUp() {
		result = Status.getValues()
			.stream()
			.collect(
				Collectors.toMap(status -> status, status -> INITIAL_PRIZE_COUNT, (a, b) -> b, LinkedHashMap::new));
	}

	@Test
	@DisplayName("게임결과를 생성한다.")
	public void createGameResult() {
		GameResult gameResult = new GameResult(result);

		assertThat(gameResult).isEqualTo(new GameResult(result));
	}

	@Test
	@DisplayName("모든 볼의 불일치 여부를 알 수 있다.")
	public void isNothing() {
		result.put(Status.NOTHING, 3);
		GameResult gameResult = new GameResult(result);

		assertThat(gameResult.isNothing()).isTrue();
	}

	@Test
	@DisplayName("게임의 상태의 종료 유무를 알 수 있다.")
	public void isContinueGame() {
		result.put(Status.STRIKE, 3);
		GameResult gameResult = new GameResult(result);

		assertThat(gameResult.isContinueGame()).isFalse();
	}

}