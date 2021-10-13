package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

	private Car car;

	@BeforeEach
	void setUp() {
		//given
		String name = "july";

		//when
		car = new Car(name);
	}

	@Test
	@DisplayName("자동차 객체 생성")
	void createCar() {
		//given
		String name = "july";

		//then
		assertThat(car.getName()).isEqualTo(name);
		assertThat(car.getPosition()).isEqualTo(0);
	}

	@Test
	@DisplayName("자동차 이동")
	void goCar() {
		//given
		int num = 5;

		//when
		car.go(num);
		car.go(num);
		car.go(num);

		//then
		assertThat(car.getPosition()).isEqualTo(3);
	}

	@Test
	@DisplayName("자동차 정지")
	void stopCar() {
		//given
		int num = 3;

		//when
		car.go(num);

		//then
		assertThat(car.getPosition()).isEqualTo(0);
	}


}