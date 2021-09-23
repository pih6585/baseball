package generator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallGeneratorTest {

	@Test
	@DisplayName("볼의 전체 숫자를 입력하면 첫번째 숫자를 생성한다.")
	public void createFirstBall() {
		int result = BallGenerator.generateFirstBall(123);

		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("볼의 전체 숫자를 입력하면 두번째 숫자를 생성한다.")
	public void createSecondBall() {
		int result = BallGenerator.generateSecondBall(123);

		assertThat(result).isEqualTo(2);
	}

	@Test
	@DisplayName("볼의 전체 숫자를 입력하면 세번째 숫자를 생성한다.")
	public void createThirdBall() {
		int result = BallGenerator.generateThirdBall(123);

		assertThat(result).isEqualTo(3);
	}
}
