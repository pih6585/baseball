package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.model.Ball;
import baseball.model.Status;

class BallTest {

	@Test
	@DisplayName("각각의 볼을 생성한다.")
	public void createBall() {
		Ball ball = new Ball(2, 0);

		assertThat(ball).isEqualTo(new Ball(2, 0));
	}

	@ParameterizedTest
	@DisplayName("볼은 1~9가 아니면 예외가 발생한다.")
	@CsvSource(value = "0,10")
	public void checkBallRange(int ballNumber) {
		assertThrows(IllegalArgumentException.class,
			() -> new Ball(ballNumber, 0));
	}

	@Test
	@DisplayName("볼과 볼의 자리수와 값이 일치하면 스트라이크이다.")
	public void playStrike() {
		Ball targetBall = new Ball(1,0);
		Ball customBall = new Ball(1,0);

		assertThat(targetBall.play(customBall)).isEqualTo(Status.STRIKE);
	}

	@Test
	@DisplayName("볼과 볼의 값이 일치하고 위치가 다르면 볼이다.")
	public void playBall() {
		Ball targetBall = new Ball(1,0);
		Ball customBall = new Ball(1,1);

		assertThat(targetBall.play(customBall)).isEqualTo(Status.BALL);
	}

	@Test
	@DisplayName("볼과 볼의 값와 위치가 다르면 nothing 이다.")
	public void playNothing() {
		Ball targetBall = new Ball(1,0);
		Ball customBall = new Ball(2,0);

		assertThat(targetBall.play(customBall)).isEqualTo(Status.NOTHING);
	}
}