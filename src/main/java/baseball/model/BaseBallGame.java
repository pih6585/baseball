package baseball.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class BaseBallGame {

	public static final int INITIAL_PRIZE_COUNT = 0;
	public static final int ADDITION_PRIZE_COUNT = 1;

	private final Balls targetBalls;

	public BaseBallGame(Balls targetBalls) {
		this.targetBalls = targetBalls;
	}

	public boolean isContinue(GameResult gameResult) {
		return gameResult.isContinueGame();
	}

	public GameResult play(Balls customBalls) {
		Map<Status, Integer> results = initResult();
		for (Ball ball : targetBalls.getBalls()) {
			Status status = customBalls.play(ball);
			results.computeIfPresent(status, (oldStatus, oldCount) -> oldCount + ADDITION_PRIZE_COUNT);
		}
		return new GameResult(results);
	}

	private Map<Status, Integer> initResult() {
		return Status.getValues()
			.stream()
			.collect(
				Collectors.toMap(status -> status, status -> INITIAL_PRIZE_COUNT, (a, b) -> b, LinkedHashMap::new));
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BaseBallGame that = (BaseBallGame)o;
		return Objects.equals(targetBalls, that.targetBalls);
	}

	@Override
	public int hashCode() {
		return Objects.hash(targetBalls);
	}
}
