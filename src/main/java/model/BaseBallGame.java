package model;

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

	public boolean isEndGame() {
		return !status.isPerfectStrike();
	}

	public Status play(Balls customBalls) {
		status = Status.init();
		IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
			.forEach(index -> status = targetBalls.play(customBalls.getBalls().get(index), index, status));
		return status;
	}
}
