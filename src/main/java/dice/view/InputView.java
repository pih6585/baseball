package dice.view;

import dice.scanner.DiceScanner;

public class InputView {

	private static final String INPUT_PLAYER_NUMBER_MESSAGE = "참여 인원은 몇명인가요?(최대4명)";
	private static final String INPUT_PLAYER_NAME_MESSAGE = "참가자의 이름을 입력하세요 :";

	public static String inputPlayerNumber() {
		System.out.println(INPUT_PLAYER_NUMBER_MESSAGE);
		return DiceScanner.readLine();
	}

	public static String inputPlayerName() {
		System.out.println(INPUT_PLAYER_NAME_MESSAGE);
		return DiceScanner.readLine();
	}
}
