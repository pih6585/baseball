package controller;

import generator.BallsGenerator;

import model.Ball;
import model.Balls;
import model.BaseBallGame;
import model.GameReStart;
import model.GameResult;
import view.InputView;
import view.OutputView;

public class Controller {

	public void run() {

		boolean isGameEnd = gameStart(BallsGenerator.createTargetBalls());

		while (isReGame() && isGameEnd) {
			isGameEnd = gameStart(BallsGenerator.createTargetBalls());
		}

		OutputView.printEndGame();
	}

	private boolean gameStart(Balls targetBalls) {
		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);

		GameResult gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(InputView.inputBalls()));

		while (baseBallGame.isContinue()) {
			OutputView.printGameResult(gameResult);
			gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(InputView.inputBalls()));
		}

		OutputView.printGameResult(gameResult);

		return !baseBallGame.isContinue();
	}

	private boolean isReGame() {
		return new GameReStart(InputView.inputChoiceReGame()).isReGame();
	}
}
