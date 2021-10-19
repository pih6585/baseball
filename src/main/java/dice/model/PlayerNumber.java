package dice.model;

import java.util.Objects;

public class PlayerNumber {

	private static final String PLAYER_NUMBER_EMPTY_OR_NULL_ERROR_MESSAGE = "참가인원이 빈값이거나 null 입니다.";
	private static final String NUMBER_RANGE_ERROR_MESSAGE = "참가인원은 2~4명 입니다.";
	private static final String NUMBER_MATCH_TYPE_ERROR_MESSAGE = "숫자만 입력 가능 합니다.";
	private static final String REGEX = "^\\d+$";
	private static final int MIN_PLAYER_NUMBER = 2;
	private static final int MAX_PLAYER_NUMBER = 4;

	private final int playerNumber;

	public PlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public PlayerNumber(String playerNumber) {
		checkEmptyOrNull(playerNumber);
		checkMatchType(playerNumber);
		this.playerNumber = toInt(playerNumber);
	}

	private int toInt(String playerNumber) {
		int number = Integer.parseInt(playerNumber);
		checkRangeNumber(number);
		return number;
	}

	private void checkRangeNumber(int number) {
		if (number < MIN_PLAYER_NUMBER || number > MAX_PLAYER_NUMBER) {
			throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
		}
	}

	private void checkMatchType(String playerNumber) {
		if (!playerNumber.matches(REGEX)) {
			throw new IllegalArgumentException(NUMBER_MATCH_TYPE_ERROR_MESSAGE);
		}
	}

	private void checkEmptyOrNull(String playerNumber) {
		if (playerNumber == null || playerNumber.isEmpty()) {
			throw new IllegalArgumentException(PLAYER_NUMBER_EMPTY_OR_NULL_ERROR_MESSAGE);
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayerNumber that = (PlayerNumber)o;
		return playerNumber == that.playerNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerNumber);
	}
}
