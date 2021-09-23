package generator;

public class BallGenerator {

	private static final int HUNDRED_UNIT = 100;
	private static final int THOUSAND_UNIT = 10;

	public static int generateFirstBall(int ballsNumber) {
		return ballsNumber / HUNDRED_UNIT;
	}

	public static int generateSecondBall(int ballsNumber) {
		return (ballsNumber % HUNDRED_UNIT) / THOUSAND_UNIT;
	}

	public static int generateThirdBall(int ballsNumber) {
		return (ballsNumber % HUNDRED_UNIT) % THOUSAND_UNIT;
	}

}
