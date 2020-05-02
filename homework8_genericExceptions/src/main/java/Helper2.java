import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Helper2 {
    SimpleIntegerCalculator calculator = new SimpleIntegerCalculator();

    public List<Character> getSign(String s) throws UnrecognisedCharacterException {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                chars.add(s.charAt(i));
            } else if (s.charAt(i) == ' ' || s.charAt(i) == ',') {
                throw new UnrecognisedCharacterException("ErrMsg 002: " + s.charAt(i)
                        + "'" + " character is not recognised!" + "Please do not use blank or comma! ");
            }
        }
        return chars;
    }

    public List<Number> getNumbers(String s) {
        String[] tokens = s.split("[+/*-]");
        double[] num = Arrays.stream(tokens)
                .mapToDouble(Double::parseDouble)
                .toArray();
        List<Number> numbers = new ArrayList<>(num.length);
        for (double i : num) {
            numbers.add(i);
        }
        return numbers;
    }

    public Number calculate(String s) throws UnrecognisedCharacterException {
        List<Character> sign = getSign(s);
        List<Number> num = getNumbers(s);
        Number result = num.get(0);
        for (int i = 0; i < sign.size(); i++) {
            result = calculator.verifySign(sign.get(i), result, num.get(i + 1));
        }
        return result;
    }

    public String getParenthesesContent(String s) {
        String sub = null;
        if (s.contains("(") || s.contains(")")) {
            sub = s.substring(s.indexOf('(') + 1, s.indexOf(')'));
        }
        return sub;
    }

    public String getCharsBeforeParentheses(String s) {
        String sub = StringUtils.substringBefore(s, "(");
        return sub;
    }

    public String getCharsAfterParentheses(String s) {
        String sub = StringUtils.substringAfter(s, ")");
        return sub;
    }

    public Number calcParenthesesContentFirst(String s) {
        String sub = getParenthesesContent(s);
        getSign(sub);
        getNumbers(sub);
        int result = (int) calculate(sub);
        return result;
    }

    public Number calcBeforeParentheses(String s) {
        Number result;
        String sub = getCharsBeforeParentheses(s);
        String[] tokens = sub.split("[+/*-]");
        if (tokens.length > 2) {
            getSign(sub);
            getNumbers(sub);
            result = (int) calculate(sub);
        } else if (tokens.length == 0) {
            result = 0;
        } else if (sub.equals("")) {
            result = 0;
        } else {
            result = Double.parseDouble(String.valueOf(tokens[0]));
        }
        return result;
    }

    public Number calcAfterParentheses(String s) {
        Number result = 0;
        String sub = getCharsAfterParentheses(s);
        String[] tokens = sub.split("[+/*-]");
        if (tokens.length > 2) {
            getSign(sub);
            getNumbers(sub);
            result = (int) calculate(sub);
        } else if (tokens.length == 0) {
            result = 0;
        } else if (sub.equals("")) {
            result = 0;
        } else {
            result = Double.parseDouble(String.valueOf(tokens[1]));
        }
        return result;
    }

    public char getSignBeforeParentheses(String s) {
        String sub;
        char c = 0;
        if (s.contains("(")) {
            if (s.charAt(0) != '(') {
                sub = StringUtils.substringBeforeLast(s, "(");
                if (sub.length() > 0) {
                    c = sub.charAt(sub.length() - 1);
                } else {
                    c = 0;
                }
            }
        }
        return c;
    }

    public char getSignAfterParentheses(String s) {
        String sub = null;
        char c = 0;
        if (s.contains(")")) {
            if ((s.substring(s.lastIndexOf(s)) != s.substring(s.indexOf(')')))) {
                sub = StringUtils.substringAfterLast(s, ")");
                if (sub.length() > 0) {
                    c = sub.charAt(0);
                } else {
                    c = 0;
                }
            }
        }
        return c;
    }

    public Number calculate2(String s) throws UnrecognisedCharacterException {
        Number result = 0;
        if (!(s.contains("(") && s.contains(")"))) {
            List<Character> sign = getSign(s);
            List<Number> num = getNumbers(s);
            result = num.get(0);
            for (int i = 0; i < sign.size(); i++) {
                result = calculator.verifySign(sign.get(i), result, num.get(i + 1));
            }
        } else {
            Number n1 = calcParenthesesContentFirst(s);
            Number n2 = calcBeforeParentheses(s);
            Number n3 = calcAfterParentheses(s);
            char c1 = getSignBeforeParentheses(s);
            char c2 = getSignAfterParentheses(s);
            if (c1 != 0) {
                if (c2 != 0 && c2 != '/' && c2 != '*') {
                    result = calculator.verifySign(c1, n2, n1);
                    result = calculator.verifySign(c2, result, n3);
                } else {
                    result = calculator.verifySign(c2, n1, n3);
                    result = calculator.verifySign(c1, n2, result);
                }
            } else {
                result = calculator.verifySign(c2, n1, n3);
            }
        }
        return result;
    }

}
