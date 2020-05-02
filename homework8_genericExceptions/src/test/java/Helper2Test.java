import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Helper2Test {
    Helper2 calculator = new Helper2();
    final static Logger logger = Logger.getLogger(HelperTest.class);

    //test if use of one set of parentheses works;
    //result integer;
    @Test
    public void test_calculate2_parentheses() {
        BasicConfigurator.configure();
        Number num = calculator.calculate2("100+(5*2)/10.2");
        assertEquals(100, 100);
        logger.debug("Test over, result: " + num );
    }
}