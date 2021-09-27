package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import model.Ball;
import model.Balls;

public class BallsGenerator {

	private static final String CHECK_BALLS_SIZE_ERROR_MESSAGE = "야구게임의 볼은 3자리 입니다.";
	private static final int START_INCLUSIVE = 0;
	private static final int BALLS_SIZE = 3;

	public static Balls createTargetBalls() {
		List<Ball> balls = new ArrayList<>();
		IntStream.range(START_INCLUSIVE, BALLS_SIZE)
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
		checkBallsSize(String.valueOf(balls));
		return new Balls(toList(String.valueOf(balls)));
	}

	public static Balls createCustomBalls(String balls) {
		checkBallsSize(balls);
		return new Balls(toList(balls));
	}

	private static List<Ball> toList(String balls) {
		return balls.chars()
			.mapToObj(ch -> Ball.createBall((char)ch))
			.collect(Collectors.toList());
	}

	private static void checkBallsSize(String balls) {
		if (balls.length() != BALLS_SIZE) {
			throw new IllegalArgumentException(CHECK_BALLS_SIZE_ERROR_MESSAGE);
		}
	}
}
