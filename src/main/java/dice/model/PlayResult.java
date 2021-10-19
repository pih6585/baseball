package dice.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayResult {

	private static final int ZERO_POINT = 0;

	private final List<PlayStatus> playResults;

	public PlayResult(List<PlayStatus> playResults) {
		this.playResults = playResults;
	}

	public int findHighScore() {
		return playResults.stream()
			.mapToInt(PlayStatus::findTotalNumber)
			.max()
			.orElse(ZERO_POINT);
	}

	public List<String> findWinners() {
		return playResults.stream()
			.filter(playStatus -> playStatus.isHighScore(findHighScore()))
			.map(PlayStatus::getName)
			.collect(Collectors.toList());
	}

	public List<PlayStatus> getPlayResults() {
		return playResults;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PlayResult that = (PlayResult)o;
		return Objects.equals(playResults, that.playResults);
	}

	@Override
	public int hashCode() {
		return Objects.hash(playResults);
	}

}
