package homework6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarMain {

    public static void main(String[] args) {
        CarMethod method = new CarMethod();
        //1) Write 5 different instances of that object;
        //Add the instances to a list;
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("Mazda", 3, 55487951));
        carList.add(new Car("Volkswagen", 10, 789841254));
        carList.add(new Car("Opel", 5, 47859652));
        carList.add(new Car("Maserati", 2, 78745412));
        carList.add(new Car("Ferrari", 6, 65352984));

        System.out.println();//2)
        System.out.println("Find the elements containing the letter 'a' that start with 'M' and print them out:");
        method.hasAStartsM(carList);
        //Add instances to set;
        method.createSet(carList);

        System.out.println();//3)
        System.out.println("Find the min using a custom comparing criteria of choice:");
        method.findMinAge(carList);

        System.out.println();//4)
        System.out.println("Generate 5 string, add to a set and find the max:");
        method.maxLength();

        System.out.println();//5)
        System.out.println("Generate random integers and count them. Counted:");
        method.countNumbers();

        System.out.println();//6)
        System.out.println("Create Map and print 'how many' elements have value over 10");
        Map<String, Integer> map = new HashMap<>();
        map.put("bread price", 2);
        map.put("jacket price", 200);
        map.put("cake price", 15);
        map.put("phone price", 2000);
        map.put("coke price", 5);
        method.valuesOver10(map);

        System.out.println();//7)
        System.out.println("Reverse set elements order:");
        method.reverseOrder();

        System.out.println();//8)
        System.out.println("Sort cars alphabetically based on brands:");
        method.sortCarList(carList);

        System.out.println();//9
        System.out.println("Print Match result. ? age > 5, true, false");
        method.matchCondition(carList);

        System.out.println();//10
        System.out.println("Optional example:");
        method.optionalExample();

        System.out.println();//11
        System.out.println("String min example:");
        method.minLength();
    }
}

