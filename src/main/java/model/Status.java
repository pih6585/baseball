package model;

import java.util.Objects;

public class Status {

	private static final int PLUS_NUMBER = 1;
	private static final int ZERO_POINT = 0;

	private final int strike;
	private final int ball;

	private Status(int strike, int ball) {
		this.strike = strike;
		this.ball = ball;
	}

	public static Status init() {
		return new Status(ZERO_POINT, ZERO_POINT);
	}

	public Status strike() {
		return new Status(strike + PLUS_NUMBER, ball);
	}

	public Status ball() {
		return new Status(strike, ball + PLUS_NUMBER);
	}

	public int getStrike() {
		return strike;
	}

	public int getBall() {
		return ball;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Status status = (Status)o;
		return strike == status.strike && ball == status.ball;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball);
	}
}
