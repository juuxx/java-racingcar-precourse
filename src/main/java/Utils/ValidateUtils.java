package Utils;

import java.util.stream.Stream;

import nextstep.utils.Randoms;

public class ValidateUtils {

	public static final int MAX_LENGTH = 5;
	public static final String SEPARATOR = ",";
	public static final int MIN_NUM = 0;
	public static final int MAX_NUM = 9;


	public static Boolean checkInputLength(String carName) {
		boolean result = carName.length() <= MAX_LENGTH;
		ErrorMessageUtils.printErrorLength(result);
		return result;
	}

	//레이싱 경주이기 때문에 한명만 출전할 수 없기 때문에 ',' 콤마는 필수
	public static Boolean checkInputComma(String userInput) {
		int isExist = userInput.indexOf(SEPARATOR);
		ErrorMessageUtils.printErrorComma(isExist != -1);
		return isExist != -1;
	}


	public static boolean checkInputRange(int userNum) {
		boolean result = userNum >= 0 && userNum < 10;
		ErrorMessageUtils.printErrorNum(result);
		return result;
	}

	public static boolean checkInputNum(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			ErrorMessageUtils.printErrorNum(false);
			return false;
		}
		return true;
	}

	public static boolean checkInputNumValid(String userInput) {
		if(checkInputNum(userInput)){
			return checkInputRange(Integer.parseInt(userInput));
		}
		return false;
	}

	public static int makeRandomNum() {
		return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
	}
}
