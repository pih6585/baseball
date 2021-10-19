package dice.controller;

import java.util.ArrayList;
import java.util.List;

import dice.model.Name;
import dice.model.PlayResult;
import dice.model.PlayStatus;
import dice.model.PlayerNumber;
import dice.service.PlayGame;
import dice.view.InputView;
import dice.view.OutputView;

public class Controller {

	public void run() {
		PlayerNumber playerNumber = new PlayerNumber(InputView.inputPlayerNumber());

		List<PlayStatus> playStatuses = playDiceGame(playerNumber);

		PlayResult playResult = new PlayResult(playStatuses);

		OutputView.printPlayerStatus(playResult);
		OutputView.printWinners(playResult);
	}

	private List<PlayStatus> playDiceGame(PlayerNumber playerNumber) {
		List<PlayStatus> playStatuses = new ArrayList<>();
		while (playerNumber.isNotFinish()) {
			Name name = new Name(InputView.inputPlayerName());
			playStatuses.add(PlayGame.play(name));
			playerNumber.addCountNumber();
		}
		return playStatuses;
	}
}
