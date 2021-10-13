package dice.model;

import java.util.Objects;

public class PlayerNumber {

	private final int playerNumber;

	public PlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public PlayerNumber(String playerNumber) {
		this.playerNumber = Integer.parseInt(playerNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayerNumber that = (PlayerNumber)o;
		return playerNumber == that.playerNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(playerNumber);
	}
}
