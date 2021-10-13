package dice.random;

import java.util.Random;

public class DiceRandom {

	private static final Random random = new Random();
	private static final int BOUND = 5;
	private static final int ADD_BOUND = 1;

	public static int randomValue() {
		return random.nextInt(BOUND) + ADD_BOUND;
	}
}
