package Utils;

import nextstep.utils.Console;

public class MessageUtils {

	public static final String INPUT_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	public static final String CHANCE_COUNT_MESSAGE = "시도할 횟수는 몇회인가요?";
	public static final String RUN_RESULT = "실행결과";

	public static String inputCarNames(){
		System.out.println(INPUT_CARS_NAME_MESSAGE);
		return Console.readLine();
	}

	public static String inputChanceCount(){
		System.out.println(CHANCE_COUNT_MESSAGE);
		return Console.readLine();
	}

	public static void showMessage() {
		System.out.println(RUN_RESULT);
	}

	public static void newline() {
		System.out.println();
	}
}
