package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Status {
	STRIKE, BALL, NOTHING;

	public static List<Status> getValues() {
		return Arrays.stream(Status.values())
			.collect(Collectors.toList());
	}
}
