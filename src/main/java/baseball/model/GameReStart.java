package baseball.model;

import java.util.Objects;

public class GameReStart {

	private static final int MIN_RANGE_NUMBER = 1;
	private static final int MAX_RANGE_NUMBER = 2;
	private static final String CHOICE_NUMBER_RANGE_ERROR_MESSAGE = "선택 숫자는 1또는 2만 가능합니다.";

	private final int choiceNumber;

	public GameReStart(int choiceNumber) {
		checkRangeNumber(choiceNumber);
		this.choiceNumber = choiceNumber;
	}

	public boolean isReGame() {
		return choiceNumber == 1;
	}

	private void checkRangeNumber(int choiceNumber) {
		if (choiceNumber < MIN_RANGE_NUMBER || choiceNumber > MAX_RANGE_NUMBER) {
			throw new IllegalArgumentException(CHOICE_NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		GameReStart that = (GameReStart)o;
		return choiceNumber == that.choiceNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(choiceNumber);
	}

}
