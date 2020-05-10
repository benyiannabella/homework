package homework1;

//Display the max digit from a number.
public class MaxDigit {
    public static void main(String[] args) {

        int num = 1983;
        int maxDigit = 0;
        int a = 1;
        while(a <= num) {
           int maxDigitTemp = num % 10;
            if (maxDigit < maxDigitTemp){
                maxDigit = maxDigitTemp;
            }
            num /= 10;
        }
        System.out.println("MaxDigit is: " + maxDigit);
    }


}
