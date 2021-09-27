package view;

import java.util.Scanner;


public class InputView {

	private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요.";
	private static final String INPUT_TYPE_MATCH_ERROR_MESSAGE = "숫자가 아닌 다른 문자를 입력하였습니다.";
	private static final String INPUT_CHOICE_RE_GAME_MESSAGE = "게임을 재시작시 1을 종료시 2를 눌러주세요.";

	private static final Scanner scanner = new Scanner(System.in);

	public static int inputBalls() {
		System.out.println(INPUT_BALLS_MESSAGE);
		return inputTypeInteger();
	}

	public static int inputChoiceReGame() {
		System.out.println(INPUT_CHOICE_RE_GAME_MESSAGE);
		return inputTypeInteger();
	}

	private static int inputTypeInteger() {
		if (!scanner.hasNextInt()) {
			throw new IllegalStateException(INPUT_TYPE_MATCH_ERROR_MESSAGE);
		}
		return scanner.nextInt();
	}
}
