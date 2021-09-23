package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import generator.BallsGenerator;

class BaseBallGameTest {

	@Test
	@DisplayName("야구게임을 생성한다.")
	public void createBaseBallGame() {
		Balls targetBalls = BallsGenerator.createTargetBalls();
		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);

		assertThat(baseBallGame).isEqualTo(new BaseBallGame(targetBalls));
	}

	@Test
	@DisplayName("야구게임의 종료여부를 알 수 있다.")
	public void isEndGame() {
		Balls targetBalls = BallsGenerator.createTargetBalls();
		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);

		Assertions.assertAll(
			() -> assertThat(baseBallGame.isContinueGame()).isTrue(),
			() -> {
				baseBallGame.play(targetBalls);
				assertThat(baseBallGame.isContinueGame()).isFalse();
			}
		);
	}

	@Test
	@DisplayName("야구게임 진행시 게임의 상태를 알 수 있다.")
	public void playBaseBallGame() {
		Balls targetBalls = BallsGenerator.createCustomBalls(123);
		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);
		Status status = baseBallGame.play(BallsGenerator.createCustomBalls(145));

		assertThat(status.existStrike()).isTrue();
		Assertions.assertAll(
			() -> assertThat(status.existStrike()).isTrue(),
			() -> {
				Status ballStatus = baseBallGame.play(BallsGenerator.createCustomBalls(415));
				assertThat(ballStatus.existBall()).isTrue();
			},
			() -> {
				Status nothingStatus = baseBallGame.play(BallsGenerator.createCustomBalls(456));
				assertThat(nothingStatus.isNothing()).isTrue();
			}
		);
	}

}