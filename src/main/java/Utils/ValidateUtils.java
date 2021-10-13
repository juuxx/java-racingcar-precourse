package Utils;

public class ValidateUtils {

	public static final int MAX_LENGTH = 5;
	public static final String SEPARATOR = ",";

	public static Boolean checkInputLength(String carName) {
		return carName.length() <= MAX_LENGTH;
	}

	//레이싱 경주이기 때문에 한명만 출전할 수 없기 때문에 ',' 콤마는 필수
	public static Boolean checkInputComma(String userInput) {
		int result = userInput.indexOf(SEPARATOR);
		return result != -1;
	}


	public static boolean checkInputRange(int userNum) {
		return userNum >= 0 && userNum < 10;
	}

	public static boolean checkInputNum(String input) {
		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
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


}
