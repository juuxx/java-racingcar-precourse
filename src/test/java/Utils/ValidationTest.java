package Utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Utils.ValidateUtils;

public class ValidationTest {


	@Test
	@DisplayName("자동차 이름 입력 유효성 체크")
	void checkCarName() {
		//given
		String car1 = "benedict";
		String car2 = "juu";

		//when
		Boolean result1 = ValidateUtils.checkInputLength(car1);
		Boolean result2 = ValidateUtils.checkInputLength(car2);

		//then
		assertThat(result1).isFalse();
		assertThat(result2).isTrue();
	}

	@Test
	@DisplayName("입력된 값이 쉼표로 됐는지 확인")
	void checkComma() {
		//given
		String userInput1 = "benedict juu seo";
		String userInput2 = "benedict,juu,seo";
		//when
		Boolean result1 = ValidateUtils.checkInputComma(userInput1);
		Boolean result2 = ValidateUtils.checkInputComma(userInput2);

		//then
		assertThat(result1).isFalse();
		assertThat(result2).isTrue();
	}

	@Test
	@DisplayName("입력한 값이 0~9까지 수인가?")
	void checkInputRange() {
		//given

		//when
		boolean result1 = ValidateUtils.checkInputRange(1);
		boolean result2 = ValidateUtils.checkInputRange(0);
		boolean result3 = ValidateUtils.checkInputRange(9);
		boolean result4 = ValidateUtils.checkInputRange(10);

		//then
		assertThat(result1).isTrue();
		assertThat(result2).isTrue();
		assertThat(result3).isTrue();
		assertThat(result4).isFalse();
	}

	@Test
	@DisplayName("입력한 값이 숫자인가?")
	void checkInputNumber() {
		//given
		String str = "다섯번";
		String num = "5";
		//when
		boolean result = ValidateUtils.checkInputNum(str);
		boolean result2 = ValidateUtils.checkInputNum(num);
		//then
		assertThat(result).isFalse();
		assertThat(result2).isTrue();
	}


}
