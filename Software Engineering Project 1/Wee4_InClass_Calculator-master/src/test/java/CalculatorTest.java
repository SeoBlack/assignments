// java.laskin;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/*
 * JUnit 5
 */

public class CalculatorTest { // The class name must end with Test

    // Fixture: all tests use the same calculator,
    // which is reset before each test.
    private Calculator calculator = new Calculator();
    private static final double DELTA = 0.001;

    @BeforeEach
    public void clearCalculator() {
        calculator.reset();
    }

    // The test method name can be anything, as long as it has the @Test annotation
    @Test
    public void testAdd() {
        calculator.add(1);
        calculator.add(2);
        assertEquals(3.0, calculator.getResult(), DELTA,
                "The sum of numbers 1 and 2 is incorrect");
    }

    @Test
    public void testSubtract() {
        calculator.add(10);
        calculator.subtract(2);
        assertEquals(8.0, calculator.getResult(), DELTA,
                "The difference between 10 and 2 is incorrect");
    }

    @Test
    @DisplayName("Test division 8 / 2")
    public void testDivide() {
        calculator.add(8);
        calculator.divide(2);
        assertEquals(4.0, calculator.getResult(), DELTA,
                "Division 8/2 is incorrect");
    }

    // The correct result of this test is that division by zero throws an exception,
    // the caller then handles it in the desired way
    @Test
    @DisplayName("Test division by zero")
    public void testDivideByZero() {
        ArithmeticException exception =
                assertThrows(ArithmeticException.class, () -> calculator.divide(0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    @DisplayName("Test multiply 2 * 2")
    public void testMultiply() {
        calculator.add(2);
        calculator.multiply(2);
        assertEquals(4.0, calculator.getResult(), DELTA,
                "2 multiplied by 2 is incorrect");
    }

    @Test
    @DisplayName("Test square root of a perfect square")
    public void testSquareRootOfPerfectSquare() {
        calculator.squareRoot(9.0);
        assertEquals(3.0, calculator.getResult(), DELTA,
                "Square root of 9 should be 3");
    }

    @Test
    @DisplayName("Test square root of non-perfect square")
    public void testSquareRootOfNonPerfectSquare() {
        calculator.squareRoot(2.0);
        assertEquals(Math.sqrt(2.0), calculator.getResult(), DELTA,
                "Square root of 2 should match Math.sqrt(2)");
    }
}
