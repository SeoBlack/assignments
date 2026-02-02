//for more info refere to this assignment https://github.com/ADirin/Sep1_Imp_2025/blob/main/Week3/In-class%20Assignment/Lecture%20Assignment.md
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
