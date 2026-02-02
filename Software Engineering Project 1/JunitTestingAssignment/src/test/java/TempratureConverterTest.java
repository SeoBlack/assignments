import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TempratureConverterTest {

    TempratureConverter tempratureConverter = new TempratureConverter();

    @Test
    public void fahrenheitToCelsiusTest(){
        double result1  = tempratureConverter.fahrenheitToCelsius(70.5);
        assertEquals(21.38,result1,2);
        double result2 =  tempratureConverter.fahrenheitToCelsius(-5);
        assertEquals(-20,result2,1);
        double result3 =  tempratureConverter.fahrenheitToCelsius(0);
        assertEquals(-17.777,result3,3);
    }
    @Test
    public void celsiusToFahrenheitTest(){
        double result1 = tempratureConverter.celsiusToFahrenheit(20);
        assertEquals(68,result1,0);
        double result2 = tempratureConverter.celsiusToFahrenheit(-20);
        assertEquals(-4,result2,0);
        double result3 = tempratureConverter.celsiusToFahrenheit(19.5);
        assertEquals(67.1,result3,1);
    }
    @Test
    public void isExtremeTempratureTest(){
        boolean result1 = tempratureConverter.isExtremeTemprature(20);
        assertEquals(false,result1);
        boolean result2 = tempratureConverter.isExtremeTemprature(-20);
        assertEquals(false,result2);
        boolean result3 = tempratureConverter.isExtremeTemprature(0);
        assertEquals(false,result3);
        boolean result4 = tempratureConverter.isExtremeTemprature(199.5);
        assertEquals(true,result4);
        boolean result5 = tempratureConverter.isExtremeTemprature(-180);
        assertEquals(true,result5);
        boolean result6 = tempratureConverter.isExtremeTemprature(123.999928);
        assertEquals(true,result6);
    }
}