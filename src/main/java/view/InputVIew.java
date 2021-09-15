package view;

import java.util.Scanner;

public class InputVIew {

	private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요.";
	private static final String INPUT_TYPE_MATCH_ERROR_MESSAGE = "숫자가 아닌 다른 문자를 입력하였습니다.";
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputBalls() {
		System.out.println(INPUT_BALLS_MESSAGE);
		if (!scanner.hasNextInt()) {
			throw new IllegalStateException(INPUT_TYPE_MATCH_ERROR_MESSAGE);
		}
		return scanner.nextInt();
	}
}
