package dice.model;

import java.util.Objects;

public class Dice {

	private static final String DICE_RANGE_ERROR_MESSAGE = "주사위는 1~6까지의 숫자만 가능합니다.";
	private static final int MIN_DICE_NUMBER = 1;
	private static final int MAX_DICE_NUMBER = 6;
	private final int dice;

	public Dice(int dice) {
		checkDiceRange(dice);
		this.dice = dice;
	}

	private void checkDiceRange(int dice) {
		if (dice < MIN_DICE_NUMBER || dice > MAX_DICE_NUMBER) {
			throw new IllegalArgumentException(DICE_RANGE_ERROR_MESSAGE);
		}
	}

	public int getDiceNumber() {
		return dice;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Dice dice1 = (Dice)o;
		return dice == dice1.dice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dice);
	}

}
