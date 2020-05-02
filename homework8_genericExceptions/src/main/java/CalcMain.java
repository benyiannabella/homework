import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class CalcMain {
    final static Logger logger = Logger.getLogger(SimpleDoubleCalculator.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();
        logger.debug("Insert a simple equation below: ");
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.nextLine();

        //double calculator does not recognise parentheses;
        //simple equations with 2 or multiple numbers;
        //Helper verify = new Helper();
        //Number result = verify.calculate(s);

        //integer calculator validates parentheses in simple equations;
        //like 1+(2*3) or (4*5)/5 or 10-(2*2)/5;
        Helper2 verify2 = new Helper2();
        Number result2 = verify2.calculate2(s);

        logger.debug("Result is: " + result2);
    }
}
