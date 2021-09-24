package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

	@Test
	@DisplayName("게임결과를 생성한다.")
	public void createGameResult() {
		GameResult gameResult = new GameResult(Status.init());

		assertThat(gameResult).isEqualTo(new GameResult(Status.init()));
	}

	@Test
	@DisplayName("모든 볼의 불일치 여부를 알 수 있다.")
	public void isNothing() {
		GameResult gameResult = new GameResult(Status.init());

		assertThat(gameResult.isNothing()).isTrue();
	}

	@Test
	@DisplayName("게임의 상태의 종료 유무를 알 수 있다.")
	public void isContinueGame() {
		Status status = Status.init();
		status = status.strike();
		status = status.strike();
		status = status.strike();
		GameResult gameResult = new GameResult(status);

		assertThat(gameResult.isContinueGame()).isFalse();
	}

}