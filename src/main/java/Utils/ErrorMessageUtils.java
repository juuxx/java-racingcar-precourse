package Utils;

public class ErrorMessageUtils {

	public static final String ERROR = "[ERROR]";
	public static final String ERROR_CONTENTS_LENGTH = "이름은 다섯글자 이하로 작성해주세요.";
	public static final String ERROR_CONTENTS_NUM = "0~9까지의 숫자만 입력해주세요.";
	public static final String ERROR_CONTENTS_COMMA = "하나 이상의 이름을 입력하거나, 쉼표(\",\")로 값을 구분해주세요.";

	public static void printErrorLength(Boolean result) {
		if(!result){
			System.out.println(ERROR + ERROR_CONTENTS_LENGTH);
		}
	}

	public static void printErrorNum(Boolean result) {
		if(!result){
			System.out.println(ERROR + ERROR_CONTENTS_NUM);
		}
	}

	public static void printErrorComma(Boolean result) {
		if(!result){
			System.out.println(ERROR + ERROR_CONTENTS_COMMA);
		}
	}
}
