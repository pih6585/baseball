package dice.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PlayStatus {

	private final Name name;
	private final List<Dice> dices;

	public PlayStatus(Name name, List<Dice> dices) {
		this.name = name;
		this.dices = Collections.unmodifiableList(dices);
	}

	public int findTotalNumber() {
		return dices.stream()
			.mapToInt(Dice::getDiceNumber)
			.sum();
	}

	public boolean isHighScore(int highScore) {
		return findTotalNumber() == highScore;
	}

	public String getName() {
		return name.getName();
	}

	public List<Dice> getDices() {
		return dices;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayStatus playStatus = (PlayStatus)o;
		return Objects.equals(name, playStatus.name) && Objects.equals(dices, playStatus.dices);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, dices);
	}

}
