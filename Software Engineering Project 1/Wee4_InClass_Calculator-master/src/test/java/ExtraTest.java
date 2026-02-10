
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExtraTest extends AbstractParent {

    private static Calculator calculator = new Calculator();
    private static final double DELTA = 0.001;

    @BeforeAll
    public static void testPowerOn() {
        System.out.println("@BeforeAll Power ON (before the first test)");
        calculator.powerOn();
    }

    @AfterAll
    public static void testPowerOff() {
        System.out.println("@AfterAll Power OFF (all tests executed).");
        calculator.powerOff();
        calculator = null;
    }

    @BeforeEach
    public void testReset() {
        System.out.println("  Reset calculator.");
        calculator.reset();
        assertEquals(0.0, calculator.getResult(), DELTA, "Reset failed");
    }

    @ParameterizedTest(name = "Square of {0} is {1}")
    @CsvSource({ "2.0, 4.0", "4.0, 16.0", "5.0, 25.0" })
    public void testSquareParameterized(double input, double expected) {
        calculator.square(input);
        assertEquals(expected, calculator.getResult(), DELTA,
                "Squaring number " + input + " is incorrect");
    }

    @ParameterizedTest(name = "Square root of {0} is {1}")
    @CsvSource({ "2.0, 1.414213562", "9.0, 3.0" })
    public void testSquareRootParameterized(double input, double expected) {
        calculator.squareRoot(input);
        assertEquals(expected, calculator.getResult(), DELTA,
                "Square root for " + input + " is incorrect");
    }

    @Test
    @DisplayName("Test negative square root returns NaN")
    public void testSquareRootNegative() {
        calculator.squareRoot(-25.0);
        assertTrue(Double.isNaN(calculator.getResult()),
                "Square root of a negative number should be NaN");
    }
}
