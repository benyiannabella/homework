import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HelperTest {

    final static Logger logger = Logger.getLogger(HelperTest.class);
    Helper verify = new Helper();

    //test if unchecked/runtime exception has been thrown;
    @Test
    public void test_throw_UnrecognisedCharacterException() {
        BasicConfigurator.configure();
        boolean thrown = false;

        try {
            verify.getSign("10,5");
        } catch (UnrecognisedCharacterException e) {
            thrown = true;
        }
        assertTrue(thrown);
        logger.debug("UnrecognisedCharacterException test over!");
    }

    //simple equation tests;
    //better with only two numbers as parentheses and operators priority not verified;
    //result in double;
    @Test
    public void test_simple_double_multiply() {
        verify.calculate("10*5*2");
        assertEquals(100.00,100.00);
    }

    @Test
    public void test_simple_double_add() {
        verify.calculate("10+5+2");
        assertEquals(17.00,17.00);
    }

    @Test
    public void test_simple_double_divide() {
        verify.calculate("10/5/2");
        assertEquals(1.00,1.00);
    }

    @Test
    public void test_simple_double_substract() {
        verify.calculate("10-5-2");
        assertEquals(3.00,3.00);
    }

}