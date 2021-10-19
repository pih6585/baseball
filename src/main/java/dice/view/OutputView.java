package dice.view;

import java.util.List;
import java.util.stream.Collectors;

import dice.model.Dice;
import dice.model.PlayResult;
import dice.model.PlayStatus;

public class OutputView {

	private static final String COLON = " : ";
	private static final String DELIMITER = "-";
	private static final String COMMA = ",";
	private static final String PRINT_RESULT_MESSAGE = "실행결과";
	private static final String PRINT_WINNERS_MESSAGE = "우승자는 %s 입니다.";

	public static void printPlayerStatus(PlayResult playResult) {
		System.out.println(PRINT_RESULT_MESSAGE);
		for (PlayStatus playStatus : playResult.getPlayResults()) {
			System.out.println(
				playStatus.getName() + COLON + printScore(playStatus.getDices()) + COLON
					+ playStatus.findTotalNumber());
		}
	}

	private static String printScore(List<Dice> dices) {
		return dices.stream()
			.map(dice -> toString(dice.getDiceNumber()))
			.collect(Collectors.joining(DELIMITER));
	}

	private static String toString(int diceNumber) {
		return String.valueOf(diceNumber);
	}

	public static void printWinners(PlayResult playResult) {
		System.out.printf(PRINT_WINNERS_MESSAGE, printWinner(playResult.findWinners()));
	}

	private static String printWinner(List<String> names) {
		return String.join(COMMA, names);
	}
}
