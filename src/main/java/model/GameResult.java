package model;

import java.util.Objects;

public class GameResult {

	private static final int ZERO_POINT = 0;
	private static final int PERFECT_CONDITION = 3;

	private final Status status;

	public GameResult(Status status) {
		this.status = status;
	}

	public boolean isNothing() {
		return status.getStrike() == ZERO_POINT && status.getBall() == ZERO_POINT;
	}

	public boolean isContinueGame() {
		return status.getStrike() != PERFECT_CONDITION;
	}

	public int countStrike() {
		return status.getStrike();
	}

	public int countBall() {
		return status.getBall();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameResult that = (GameResult)o;
		return Objects.equals(status, that.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status);
	}
}
