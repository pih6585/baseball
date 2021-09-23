package model;

import java.util.Objects;
import java.util.stream.IntStream;

public class BaseBallGame {

	private static final int START_INCLUSIVE = 0;
	private static final int END_EXCLUSIVE = 3;

	private Status status;
	private final Balls targetBalls;

	public BaseBallGame(Balls targetBalls) {
		this.targetBalls = targetBalls;
		status = Status.init();
	}

	public boolean isContinueGame() {
		return !status.isPerfectStrike();
	}

	public Status play(Balls customBalls) {
		status = Status.init();
		IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
			.forEach(index -> status = targetBalls.play(customBalls.getBalls().get(index), index, status));
		return status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseBallGame that = (BaseBallGame)o;
		return Objects.equals(status, that.status) && Objects.equals(targetBalls, that.targetBalls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, targetBalls);
	}
}
