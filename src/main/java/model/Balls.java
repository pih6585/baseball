package model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Balls {

	private static final String CHECK_BALLS_SIZE_ERROR_MESSAGE = "야구게임의 볼은 3자리 입니다.";
	private static final String CHECK_DUPLICATION_ERROR_MESSAGE = "중복된 숫자가 존재 합니다.";
	private static final int BALLS_SIZE = 3;

	private final List<Ball> balls;

	public Balls(List<Ball> balls) {
		checkBallsSize(balls);
		checkDuplication(balls);
		this.balls = Collections.unmodifiableList(balls);
	}

	public Status play(Ball customBall) {
		return balls.stream()
			.map(ball -> ball.play(customBall))
			.filter(status -> status != Status.NOTHING)
			.findFirst()
			.orElse(Status.NOTHING);
	}

	private void checkDuplication(List<Ball> balls) {
		if (balls.size() != balls.stream()
			.distinct()
			.count()) {
			throw new IllegalArgumentException(CHECK_DUPLICATION_ERROR_MESSAGE);
		}
	}

	private void checkBallsSize(List<Ball> balls) {
		if (balls.size() != BALLS_SIZE) {
			throw new IllegalArgumentException(CHECK_BALLS_SIZE_ERROR_MESSAGE);
		}
	}

	public List<Ball> getBalls() {
		return balls;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Balls balls1 = (Balls)o;
		return Objects.equals(balls, balls1.balls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(balls);
	}

}
