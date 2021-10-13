package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

	private Cars cars;

	@BeforeEach
	void setUp(){
		//given
		Car car1 = new Car("A");
		Car car2 = new Car("B");
		Car car3 = new Car("C");

		//when
		cars = new Cars(Arrays.asList(car1, car2, car3));
	}

	@Test
	@DisplayName("자동차 리스트 생성")
	void name() {
		//then
		cars.print();
	}

	@Test
	@DisplayName("자동차 전진 테스트")
	void goCars() {
		//given
		int count = 5;

		//when
		for (int i = 0; i < count; i++){
			cars.go();
		}

		//then
		cars.print();
	}

	@Test
	@DisplayName("제일 많이 간 자동차의 거리 구하기")
	void maxPosition() {
		//given
		int count = 10;

		//when
		for (int i = 0; i < count; i++){
			cars.go();
		}

		//then
		int max = cars.getMaxPosition();
		cars.print();
		System.out.println("max = " + max);
	}

	@Test
	@DisplayName("우승자 구하기")
	void whoIsWinner() {
		//given
		int count = 10;

		//when
		for (int i = 0; i < count; i++){
			cars.go();
		}

		//then
		cars.getWinner();
	}
}