package model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StatusTest {

	@Test
	@DisplayName("게임의 상황을 초기화 한다.")
	public void initStatus() {
		Status status = Status.init();

		assertThat(status).isEqualTo(Status.init());
	}

	@Test
	@DisplayName("스트라이크이면 스트라이크 점수가 1점씩 올라간다.")
	public void strike() {
		Status status = Status.init();
		status = status.strike();
		assertThat(status.getStrike()).isEqualTo(1);
	}

	@Test
	@DisplayName("볼이면 볼의 점수가 1점씩 올라간다.")
	public void ball() {
		Status status = Status.init();
		status = status.ball();
		assertThat(status.getBall()).isEqualTo(1);
	}

}