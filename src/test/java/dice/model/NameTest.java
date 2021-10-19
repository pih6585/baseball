package dice.model;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NameTest {

	@Test
	@DisplayName("참가자 이름을 생성한다.")
	public void createName(){
		Name name = new Name("abc");

		assertThat(name).isEqualTo(new Name("abc"));
	}

	@Test
	@DisplayName("이름이 빈값이면 예외가 발생한다.")
	public void checkEmpty(){
		assertThrows(IllegalArgumentException.class,
			() -> new Name(""));
	}

	@Test
	@DisplayName("이름이 null 이면 예외가 발생한다.")
	public void checkNull(){
		assertThrows(IllegalArgumentException.class,
			() -> new Name(null));
	}

	@Test
	@DisplayName("이름이 5글자를 넘어가면 이면 예외가 발생한다.")
	public void checkNameLength(){
		assertThrows(IllegalArgumentException.class,
			() -> new Name("dicing"));
	}

	@ParameterizedTest
	@DisplayName("이름이 영문이 아니면 이면 예외가 발생한다.")
	@CsvSource(value = {"ab1","1ㄱz","1234","주사위","!@#$"})
	public void checkNameMatchRegexp(String name){
		assertThrows(IllegalArgumentException.class,
			() -> new Name(name));
	}

}