package view;

import model.Status;

public class OutputView {

	private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String EMPTY_MESSAGE = "";

	public static void printGameResult(Status status) {
		if (!status.isNothing()) {
			printGameReview(status);
		}
		if (status.isNothing()) {
			System.out.println(NOTHING_MESSAGE);
		}
		if (status.isPerfectStrike()) {
			System.out.println(END_GAME_MESSAGE);
		}
	}

	private static void printGameReview(Status status) {
		String strikeMessage = EMPTY_MESSAGE;
		String ballMessage = EMPTY_MESSAGE;
		if (status.existStrike()) {
			strikeMessage = status.getStrike() + "스트라이크";
		}
		if (status.existBall()) {
			ballMessage = status.getBall() + "볼";
		}
		System.out.println(strikeMessage + " " + ballMessage);
	}
}
