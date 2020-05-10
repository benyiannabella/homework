package homework6;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

public class CarMethod {

    //2) Find the elements containing the letter "a" that start with "M" and print them out;
    public void hasAStartsM(ArrayList<Car> newList) {
        newList.stream()
                .filter(a -> a.getBrand().contains("a"))
                .filter(c -> c.getBrand().startsWith("M"))
                .forEach(car -> System.out.println(car.getBrand()));
    }
    //Add instances to set;
    public void createSet(ArrayList<Car> car) {
        new HashSet<>(car);
    }

    //3) Find the "min" using a custom comparing criteria of choice;
    public void findMinAge(ArrayList<Car> newList) {
        Optional<Car> youngestCar = newList.stream()
                .min(Comparator.comparing(Car::getAge));
        //noinspection OptionalGetWithoutIsPresent
        System.out.println(youngestCar.get().toString());
    }

    //4) Generate 5 random Strings and add them to a Set. Find the "max" (while explaining as Javadoc how comparing Strings works);
    public void generateString(HashSet<String> newSet) {
        int s = 2;
        for (int i = 0; i < 5; i++) {
            s += i;
            String generatedString = RandomStringUtils.randomAlphabetic(s);
            newSet.add(generatedString.toLowerCase());
        }
        newSet.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
    }

    public void maxLength() {
        /**
         * using Stream.max() method with Comparator
         * here, the string with maximum character length
         * is stored in variable maxString1;
         */
        HashSet<String> newSet = new HashSet<>();
        generateString(newSet);
        Optional<String> maxString1 = newSet.stream()
                .max(Comparator.comparing(String::length));
        System.out.println("String with max character length: " + maxString1);
    }

    //5) Generate a random number of Integers and then count them. "Map" the exponential to the numbers and then print them out.
    //generate randomly integers and add to list;
    public void generateNumbers(ArrayList<Integer> randomNumbers) {
        for (int i = 0; i < 10; i++) {
            randomNumbers.add((int) (Math.random() * 100));
        }
    }

    //count numbers;
    public void countNumbers() {
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        generateNumbers(randomNumbers);
        Optional<Long> randomNum = (Optional.of((long) randomNumbers.size()));
        System.out.println(randomNum);

        System.out.println("Exponential:");//Map the exponential?
        randomNumbers.stream()
                .mapToInt(e -> (int) Math.pow(e, randomNumbers.size()))
                .forEach(System.out::println);
    }

    //6) Create a map of "n" (K,V) elements and print "how many" elements have value over 10 (the key is of your choice);
    public void valuesOver10(Map<String, Integer> newMap) {
        Optional<Long> count = Optional.of(newMap.entrySet().stream()
                .filter(x -> x.getValue() > 10)
                .count());
        System.out.println(count);
    }

    //7) Sort the above Set<String> (used for max) in reverse order;
    public void reverseOrder() {
        HashSet<String> newSet = new HashSet<>();
        generateString(newSet);
        newSet.stream()
                .sorted(Collections.reverseOrder(Comparator.comparing(String::length)))
                .forEach(System.out::println);
    }

    //8) Sort the above List of custom objects (used for filter) in an order you consider;
    //sort by car brand alphabetically;
    public void sortCarList(ArrayList<Car> carList) {
        carList.stream()
                .sorted(Comparator.comparing(Car::getBrand))
                .forEach(System.out::println);
    }

    //9) Check if any of your instances "match" a condition based on an Integer field (of your choice). What does it return ? Print it out;
    public void matchCondition(ArrayList<Car> carList) {
        boolean result = carList.stream()
                .anyMatch(x -> x.getAge() > 5);
        System.out.println(result);
    }

    //10) What does Optional represent ? Explain through an example on your custom object;
    public void optionalExample() {
        //Optional is a wrapper class which makes a field optional which means it may or may not have values;
        // in this case checks if car brand exists;
        Car car = new Car("Mini", 0, 45879456);
        Optional<String> optional = Optional.of(car.getBrand());
        optional.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Car not found!"));
    }

    //11) Fastest way to find the shortest String in a List (take the 5 random Strings generated above and find the shortest one);
    public void minLength() {
        HashSet<String> newSet = new HashSet<>();
        generateString(newSet);
        Optional<String> minString = newSet.stream()
                .min(Comparator.comparing(String::length));
        System.out.println("String with min character length: " + minString);
    }
}
