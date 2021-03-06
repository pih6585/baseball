package baseball.view;

import baseball.model.GameResult;

public class OutputView {

	private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String BALL_MESSAGE = "볼";
	private static final String NOTHING_MESSAGE = "낫싱";
	private static final String EMPTY_MESSAGE = "";
	private static final String RE_END_GAME_MESSAGE = "게임이 종료 되었습니다.";
	private static final int ZERO_POINT = 0;
	
	public static void printGameResult(GameResult gameResult) {
		if (!gameResult.isNothing()) {
			printGameReview(gameResult);
		}
		if (gameResult.isNothing()) {
			System.out.println(NOTHING_MESSAGE);
		}
		if (!gameResult.isContinueGame()) {
			System.out.println(END_GAME_MESSAGE);
		}
	}

	private static void printGameReview(GameResult gameResult) {
		String strikeMessage = EMPTY_MESSAGE;
		String ballMessage = EMPTY_MESSAGE;
		if (gameResult.countStrike() > ZERO_POINT) {
			strikeMessage = gameResult.countStrike() + STRIKE_MESSAGE;
		}
		if (gameResult.countBall() > ZERO_POINT) {
			ballMessage = gameResult.countBall() + BALL_MESSAGE;
		}
		System.out.println(strikeMessage + " " + ballMessage);
	}

	public static void printEndGame() {
		System.out.println(RE_END_GAME_MESSAGE);
	}
}
