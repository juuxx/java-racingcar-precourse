package domain;

import java.util.ArrayList;
import java.util.List;

import Utils.ValidateUtils;

public class Cars {

	private final List<Car> cars;

	public Cars(List<Car> answers) {
		this.cars = mapCar(answers);
	}

	private static List<Car> mapCar(List<Car> answers) {
		List<Car> cars = new ArrayList<>();
		for (Car answer : answers) {
			cars.add(new Car(answer.getName()));
		}
		return cars;
	}

	public void print() {
		for (Car car : this.cars) {
			car.print();
		}
	}

	public void go() {
		for (Car car : this.cars) {
			int num = ValidateUtils.makeRandomNum();
			car.go(num);
		}
	}

	public int getMaxPosition() {
		int max = 0;
		for (Car car : this.cars) {
			int pos = car.getPosition();
			max = comparePosition(max, pos);
		}
		return max;
	}

	public int comparePosition(int temp, int pos) {
		if (pos >= temp) {
			temp = pos;
		}
		return temp;
	}

	public void getWinner(){
		List<Car> winners = getWinnerList();
		ResultMessage.printWinner(winners);
	}

	public List<Car> getWinnerList() {
		List<Car> winners = new ArrayList<>();

		int maxPosition = getMaxPosition();

		for (Car car : this.cars) {
			if (maxPosition == car.getPosition()){
				winners.add(car);
			}
		}

		return winners;
	}



}

