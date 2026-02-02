public class TempratureConverter {
    public double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit - 32)*((double) 5 /9);
    }
    public double celsiusToFahrenheit(double celsius){
        return (celsius*((double )9 /5)) + 32;
    }
    //assuming the temp will be in Celsius
    public boolean isExtremeTemprature(double temprature){
        if(temprature > 50 || temprature < -40){
            return true;
        }
        return false;
    }

}
