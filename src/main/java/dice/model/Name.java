package dice.model;

import java.util.Objects;

public class Name {

	private static final String NAME_EMPTY_OR_NULL_ERROR_MESSAGE = "이름이 빈값이거나 null 입니다.";
	private static final String NAME_LENGTH_LIMIT_OVER_ERROR_MESSAGE = "이름은 5글자 이상이 될 수 없습니다.";
	private static final String NAME_MATCH_CHECK_ERROR_MESSAGE = "이름은 영문만 가능합니다.";
	private static final String REG_EXP = "^[a-zA-Z]*$";
	private static final int LIMIT_LENGTH = 5;
	private final String name;

	public Name(String name) {
		checkEmptyOrNull(name);
		checkNameLength(name);
		checkMatchRegexp(name);
		this.name = name;
	}

	private void checkMatchRegexp(String name) {
		if (!name.matches(REG_EXP)) {
			throw new IllegalArgumentException(NAME_MATCH_CHECK_ERROR_MESSAGE);
		}
	}

	private void checkNameLength(String name) {
		if (name.length() > LIMIT_LENGTH) {
			throw new IllegalArgumentException(NAME_LENGTH_LIMIT_OVER_ERROR_MESSAGE);
		}
	}

	private void checkEmptyOrNull(String name) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException(NAME_EMPTY_OR_NULL_ERROR_MESSAGE);
		}
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Name name1 = (Name)o;
		return Objects.equals(name, name1.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
