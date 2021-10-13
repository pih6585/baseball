package baseball.generator;

import java.util.Random;

public class RandomGenerator {

	private static final Random random = new Random();
	private static final int BOUND = 8;
	private static final int ADD_NUMBER = 1;

	public static int generateRandom() {
		return random.nextInt(BOUND) + ADD_NUMBER;
	}
}
