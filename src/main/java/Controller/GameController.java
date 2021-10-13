package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.MessageUtils;
import Utils.ValidateUtils;
import domain.Car;
import domain.Cars;

public class GameController {

	public void play(){

		Cars cars = createCars();
		racing(cars);
		whoIsWinner(cars);
	}


	private Cars createCars(){
		List<String> carNames = getUserInputCarNames();
		return new Cars(createCar(carNames));
	}

	private void racing(Cars cars){
		int chanceCount = getUserInputCount();
		MessageUtils.showMessage();
		for (int i = 0; i < chanceCount; i++) {
			moveCar(cars);
		}
	}

	private void moveCar(Cars cars) {
		cars.go();
		cars.print();
		MessageUtils.newline();
	}

	private void whoIsWinner(Cars cars) {
		cars.getWinner();
	}

	private int getUserInputCount() {
		String inputChanceCount = "";
		boolean isContinue ;
		do{
			inputChanceCount = MessageUtils.inputChanceCount();
			isContinue = ValidateUtils.checkInputNumValid(inputChanceCount);
		}while (!isContinue);

		return Integer.parseInt(inputChanceCount);
	}


	private List<Car> createCar(List<String> carNames) {
		List<Car> cars = new ArrayList<>();
		for (String carName : carNames) {
			Car car = new Car(carName);
			cars.add(car);
		}
		return cars;
	}

	private List<String> getUserInputCarNames(){
		boolean isContinue ;
		String userInput = "";
		List<String> carNames = new ArrayList<>();

		do{
			userInput = MessageUtils.inputCarNames();
			isContinue = ValidateUtils.checkInputComma(userInput);
			if (!isContinue){
				break;
			}

			String str = userInput.replace(" ", "");
			carNames = Arrays.asList(str.split(","));
			for (String carName : carNames) {
				isContinue = ValidateUtils.checkInputLength(carName);
				if(!isContinue){
					break;
				}
			}
		}while (!isContinue);

		return carNames;
	}
}
