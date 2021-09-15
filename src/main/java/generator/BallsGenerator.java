package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import model.Ball;
import model.Balls;

public class BallsGenerator {

	private static final String CHECK_BALLS_SIZE_ERROR_MESSAGE = "야구게임의 볼은 3자리 입니다.";
	private static final int HUNDRED_UNIT = 100;
	private static final int THOUSAND_UNIT = 10;
	private static final int START_INCLUSIVE = 0;
	private static final int END_EXCLUSIVE = 3;
	private static final int BALLS_SIZE = 3;
	private static final int PLUS_NUMBER = 1;

	public static Balls createTargetBalls() {
		List<Ball> balls = new ArrayList<>();
		IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
			.forEach(i -> balls.add(addBall(balls)));
		return new Balls(balls);
	}

	private static Ball addBall(List<Ball> balls) {
		Ball ball = new Ball(RandomGenerator.generateRandom());
		if (balls.contains(ball)) {
			return addBall(balls);
		}
		return ball;
	}

	public static Balls createCustomBalls(int balls) {
		checkBallsSize(balls);
		return new Balls(toList(balls));
	}

	private static List<Ball> toList(int ballsNumber) {
		List<Ball> balls = new ArrayList<>();
		balls.add(new Ball(ballsNumber / HUNDRED_UNIT));
		balls.add(new Ball((ballsNumber % HUNDRED_UNIT) / THOUSAND_UNIT));
		balls.add(new Ball((ballsNumber % HUNDRED_UNIT) % THOUSAND_UNIT));
		return balls;
	}

	private static void checkBallsSize(int balls) {
		if ((int)Math.log10(balls) + PLUS_NUMBER != BALLS_SIZE) {
			throw new IllegalArgumentException(CHECK_BALLS_SIZE_ERROR_MESSAGE);
		}
	}
}
