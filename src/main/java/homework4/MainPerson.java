package homework4;

import java.util.*;

public class MainPerson {
    public static void main(String[] args) {
        //create Person objects;
        Person person1 = new Person("Jane Doe", 32);
        Person person2 = new Person("Dean Parker", 20);
        Person person3 = new Person("Mary Pierce", 45);
        Person person4 = new Person("Alvin Moon", 71);
        //create new TreeSet with name comparator to sort based on Name; add persons to treeset;
        Collection<Person> newPersonName = new TreeSet<Person>(new CompareName());
        newPersonName.add(person1);
        newPersonName.add(person2);
        newPersonName.add(person3);
        newPersonName.add(person4);
        System.out.println("Display persons sorted by Name:");
        for (Person person : newPersonName) {
            System.out.println(person.getPersonName() + " age " + person.getPersonAge() + ".");
        }

        //create TreeSet with age comparator, to sort by age and add persons;
        TreeSet<Person> newPersonAge = new TreeSet<Person>(new CompareAge());
        newPersonAge.add(person1);
        newPersonAge.add(person2);
        newPersonAge.add(person3);
        newPersonAge.add(person4);
        System.out.println();
        System.out.println("Display persons sorted by Age:");
        for (Person age : newPersonAge) {
            System.out.println(age.getPersonName() + " age " + age.getPersonAge() + ".");
        }

        List<Address> addresses = new LinkedList<>();
        Address address1 = new Address("Morgan Str, NR. 5, Washington");
        Address address2 = new Address("Bakery Str, NR. 11, California");
        Address address3 = new Address("Thomas Str, NR. 500, Florida");
        Address address4 = new Address("High Str, NR. 101, Oregon");

        Hobby hobby1 = new Hobby("cycling");
        Hobby hobby2 = new Hobby("reading");
        Hobby hobby3 = new Hobby("playing badminton");
        Hobby hobby4 = new Hobby("power walking");

        System.out.println();
        System.out.println("Print the names of the hobbies and the addresses where it can be practiced:");
        person1.addPerson(person1, hobby1, address1);
        person2.addPerson(person2, hobby2, address2);
        person3.addPerson(person3, hobby3, address3);
        person4.addPerson(person4, hobby4, address4);
    }
}
