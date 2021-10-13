package Utils;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Utils.MessageUtils;
import Utils.ValidateUtils;

public class ErrorPrintTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	@DisplayName("자동차 이름이 5글자 넘는 경우 에러메세지 출력")
	void printErrorMessage1() {
		//given
		Boolean result1 = ValidateUtils.checkInputLength("benedict");

		//when
		MessageUtils.printErrorLength(result1);

		//then
		assertThat(outContent.toString()).contains(MessageUtils.ERROR_CONTENTS_LENGTH);
	}

	@Test
	@DisplayName("입력된 값이 0~9가 아닐 경우")
	void printErrorMessage2() {
		//given
		Boolean result1 = ValidateUtils.checkInputNumValid("열");

		//when
		MessageUtils.printErrorNum(result1);

		//then
		assertThat(outContent.toString()).contains(MessageUtils.ERROR_CONTENTS_NUM);
	}

	@Test
	@DisplayName("입력된 값이 쉼표로 구분된 값이 아니거나, 한개의 자동차 이름만 입력한 경우")
	void printErrorMessage3() {
		//given
		Boolean result1 = ValidateUtils.checkInputComma("benedict juu seo");
		Boolean result2 = ValidateUtils.checkInputComma("benedict");

		//when
		MessageUtils.printErrorComma(result1);
		MessageUtils.printErrorComma(result2);

		//then
		assertThat(outContent.toString()).contains(MessageUtils.ERROR_CONTENTS_COMMA);
	}


}
