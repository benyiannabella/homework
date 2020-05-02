import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Helper {
    SimpleDoubleCalculator calculator = new SimpleDoubleCalculator();

    //method extracts the numbers from the string in a double array;
    public double[] getNumbers(String s) {
        String[] tokens = s.split("[+/*-]");
        double[] doubleValues = Arrays.stream(tokens)
                .mapToDouble(Double::parseDouble)
                .toArray();
        return doubleValues;
    }

    //method extracts the signs from the string into a character list;
    public List<Character> getSign(String s) throws UnrecognisedCharacterException {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                chars.add(s.charAt(i));
            } else if (s.charAt(i) == ' ' || s.charAt(i) == ',') {
                throw new UnrecognisedCharacterException("ErrMsg 002: '" + s.charAt(i)
                        + "'" + " character is not recognised!" + "Please do not use blank or comma! ");
            }
        }
        return chars;
    }

    //method which does the calculation by combining the character list with the double[]
    // verifies the signs to determine based on operator which operation to run;
    public Number calculate(String s) {
        List<Character> sign = getSign(s);
        double[] num = getNumbers(s);
        Number result = num[0];
        for (int i = 0; i < sign.size(); i++) {
            result = calculator.verifySign(sign.get(i), result, num[i + 1]);
        }
        return result;
    }
}