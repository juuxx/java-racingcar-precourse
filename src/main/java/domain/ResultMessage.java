package domain;

import java.util.List;

public class ResultMessage {

	public static final String DASH = "-";
	public static final String STR = ":";
	public static final String COMMA = ",";
	public static final String MESSAGE_PREFIX = "최종 우승자는";
	public static final String MESSAGE_SUFFIX = "입니다.";
	public static final String MESSAGE_SPACE = " ";

	public static void print(Car car) {
		StringBuilder sb = new StringBuilder();
		sb.append(car.getName());
		sb.append(STR);
		sb.append(getViewPosition(car.getPosition()));

		System.out.println(sb);
	}

	private static StringBuilder getViewPosition(int position) {
		StringBuilder positionView = new StringBuilder();
		for (int i = 0; i < position; i++){
			positionView.append(DASH);
		}
		return positionView;
	}


	public static void printWinner(List<Car> winners) {
		StringBuilder sb = new StringBuilder();
		sb.append(MESSAGE_PREFIX);
		sb.append(MESSAGE_SPACE);
		sb.append(getCarNames(winners));
		sb.append(MESSAGE_SPACE);
		sb.append(MESSAGE_SUFFIX);

		System.out.println(sb);
	}

	public static String getCarNames(List<Car> cars){
		String names = "";
		for (Car car : cars) {
			names += car.getName();
			names += COMMA;
		}

		return removeComma(names);
	}

	public static String removeComma(String str) {
		return str.endsWith(COMMA) ? str.substring(0, str.length() - 1) : str;
	}
}
