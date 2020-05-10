package homework8_genericExceptions;

import org.apache.log4j.Logger;

public class SimpleIntegerCalculator implements Operations{

    final static Logger logger = Logger.getLogger(SimpleDoubleCalculator.class);

    @Override
    public Number verifySign(char sign, Number num1, Number num2) {

        SimpleIntegerCalculator calculator = new SimpleIntegerCalculator();
        Number result = 0;

        if (sign == '+') {
            result = calculator.add(num1, num2);
        } else if (sign == '-') {
            result = calculator.substract(num1, num2);
        } else if (sign == '*') {
            result = calculator.multiply(num1, num2);
        } else if (sign == '/') {
            try {
                result = calculator.divide(num1, num2);
            } catch (Exception exception) {
                exception.printStackTrace();
            } finally {
                logger.info("If calculation failed, try again!");
            }
        }
        return result;
    }

    @Override
    public Number add(Number num1, Number num2) {
        return (num1.intValue() + num2.intValue());
    }

    @Override
    public Number divide(Number num1, Number num2) throws DivisionByZeroException {
        if (num2.intValue() == 0 ) {
                throw new DivisionByZeroException("ErrMsg 001: Divisor cannot be zero! Please insert another number!");
        } return (num1.intValue() / num2.intValue());
    }

    @Override
    public Number multiply(Number num1, Number num2) {
        return (num1.intValue() * num2.intValue());
    }

    @Override
    public Number substract(Number num1, Number num2) {
        return (num1.intValue() - num2.intValue());
    }

}
