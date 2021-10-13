package domain;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarPrintTest {
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
	@DisplayName("실행결과 출력")
	void printResult() {
		//given
		String name = "july";
		Car car = new Car(name);
		//when
		car.go(5);
		car.go(5);
		car.go(3);

		car.print();

		//then
		assertThat(outContent.toString()).contains("july:--");

	}
}
