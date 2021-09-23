package controller;

import generator.BallsGenerator;

import model.Balls;
import model.BaseBallGame;
import model.Status;
import view.InputVIew;
import view.OutputView;

public class Controller {

	public void run() {
		Balls targetBalls = BallsGenerator.createTargetBalls();

		BaseBallGame baseBallGame = new BaseBallGame(targetBalls);

		Status status = baseBallGame.play(BallsGenerator.createCustomBalls(InputVIew.inputBalls()));
		while (baseBallGame.isContinueGame()) {
			OutputView.printGameResult(status);
			status = baseBallGame.play(BallsGenerator.createCustomBalls(InputVIew.inputBalls()));
		}

		OutputView.printGameResult(status);

	}
}
