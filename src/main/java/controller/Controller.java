package controller;

import generator.BallsGenerator;

import model.Balls;
import model.BaseBallGame;
import model.GameResult;
import view.InputVIew;
import view.OutputView;

public class Controller {

	public void run() {
		Balls targetBalls = BallsGenerator.createTargetBalls();

		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);

		GameResult gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(InputVIew.inputBalls()));
		while (baseBallGame.isContinue()) {
			OutputView.printGameResult(gameResult);
			gameResult = baseBallGame.play(BallsGenerator.createCustomBalls(InputVIew.inputBalls()));
		}

		OutputView.printGameResult(gameResult);

	}
}
