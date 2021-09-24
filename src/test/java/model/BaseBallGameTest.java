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
			() -> assertThat(baseBallGame.isContinue()).isTrue(),
			() -> {
				baseBallGame.play(targetBalls);
				assertThat(baseBallGame.isContinue()).isFalse();
			}
		);
	}

	@Test
	@DisplayName("야구게임 진행시 게임의 상태를 알 수 있다.")
	public void playBaseBallGame() {
		Balls targetBalls = BallsGenerator.createCustomBalls(123);
		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);
		GameResult gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(145));

		Assertions.assertAll(
			() -> assertThat(gameResult.countStrike()).isEqualTo(1),
			() -> {
				GameResult ballResult = baseBallGame.play(BallsGenerator.createCustomBalls(415));
				assertThat(ballResult.countBall()).isEqualTo(1);
			},
			() -> {
				GameResult nothingResult = baseBallGame.play(BallsGenerator.createCustomBalls(456));
				assertThat(nothingResult.countStrike()).isEqualTo(0);
				assertThat(nothingResult.countBall()).isEqualTo(0);
			}
		);
	}

}