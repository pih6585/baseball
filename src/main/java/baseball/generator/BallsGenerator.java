package baseball.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import baseball.model.Ball;
import baseball.model.Balls;

public class BallsGenerator {

	private static final String CHECK_BALLS_SIZE_ERROR_MESSAGE = "야구게임의 볼은 3자리 입니다.";
	private static final int START_INCLUSIVE = 0;
	private static final int BALLS_SIZE = 3;

	public static Balls createTargetBalls() {
		List<Ball> balls = new ArrayList<>();
		IntStream.range(START_INCLUSIVE, BALLS_SIZE)
			.forEach(i -> balls.add(addBall(balls, i)));
		return new Balls(balls);
	}

	private static Ball addBall(List<Ball> balls, int position) {
		int ball = RandomGenerator.generateRandom();
		if (checkExistBall(balls, ball)) {
			return addBall(balls, position);
		}
		return new Ball(ball, position);
	}

	private static boolean checkExistBall(List<Ball> balls, int ball) {
		return balls.stream()
			.anyMatch(matchBall -> matchBall.isSameNumber(ball));
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
		return IntStream.range(START_INCLUSIVE, balls.length())
			.mapToObj(i -> Ball.createBall(balls.charAt(i), i))
			.collect(Collectors.toList());
	}

	private static void checkBallsSize(String balls) {
		if (balls.length() != BALLS_SIZE) {
			throw new IllegalArgumentException(CHECK_BALLS_SIZE_ERROR_MESSAGE);
		}
	}
}
