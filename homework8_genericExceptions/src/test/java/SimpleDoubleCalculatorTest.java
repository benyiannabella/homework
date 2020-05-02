import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleDoubleCalculatorTest {
    final static Logger logger = Logger.getLogger(SimpleDoubleCalculatorTest.class);
    SimpleDoubleCalculator calculator = new SimpleDoubleCalculator();


    //test if checked exception is thrown;
    @Test
    public void divisionByZeroException_thenAssertionSucceeds() {
        BasicConfigurator.configure();
        Exception exception = assertThrows(DivisionByZeroException.class, () -> calculator.divide(10.00, 0.00));

        String expectedMessage = "ErrCode: 001 Divisor cannot be zero! Please insert another number!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        logger.debug("DivisionByZeroException test over!");
    }

}