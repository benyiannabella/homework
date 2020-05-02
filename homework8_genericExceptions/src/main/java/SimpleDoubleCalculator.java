import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class SimpleDoubleCalculator implements Operations<Number> {
    final static Logger logger = Logger.getLogger(SimpleDoubleCalculator.class);

    //method determines the operation based on the used operator;
    @Override
    public Number verifySign(char sign, Number num1, Number num2) {

        BasicConfigurator.configure();
        SimpleDoubleCalculator calculator = new SimpleDoubleCalculator();
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
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                logger.debug("If calculation failed, Try Again!");
            }
        }
        return result;
    }

    //addition;
    @Override
    public Number add(Number num1, Number num2) {
        return (num1.doubleValue() + num2.doubleValue());
    }

    //division;
    //throws DivisionByZeroException;
    @Override
    public Number divide(Number num1, Number num2) throws DivisionByZeroException {
        if ((double) num2 == 0) {
                throw new DivisionByZeroException("ErrCode: 001 Divisor cannot be zero! Please insert another number!");
        } else {
            return (num1.doubleValue() / num2.doubleValue());
        }
    }

    //multiplication calculation;
    @Override
    public Number multiply(Number num1, Number num2) {
        return (num1.doubleValue() * num2.doubleValue());
    }

    //substraction;
    @Override
    public Number substract(Number num1, Number num2) {
        return (num1.doubleValue() - num2.doubleValue());
    }
}
