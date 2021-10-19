package dice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import dice.model.Dice;
import dice.model.Name;
import dice.model.PlayStatus;
import dice.random.DiceRandom;

public class PlayGame {

	private static final int START_INCLUSIVE = 0;
	private static final int END_EXCLUSIVE = 2;

	public static PlayStatus play(Name name) {
		return new PlayStatus(name, getDices());
	}

	private static List<Dice> getDices() {
		return IntStream.range(START_INCLUSIVE, END_EXCLUSIVE)
			.mapToObj(dice -> new Dice(DiceRandom.randomValue()))
			.collect(Collectors.toList());
	}
}
