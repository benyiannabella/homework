package homework4;

import java.util.*;

public class Person {
    private String personName;
    private int personAge;

    //constructor
    public Person(String personName, int personAge) {
        this.personName = personName;
        this.personAge = personAge;
    }

    public String getPersonName() {
        return personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    //override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personAge == person.personAge &&
                personName.equals(person.personName);
    }

    //override hashcode
    @Override
    public int hashCode() {
        return Objects.hash(personName, personAge);
    }

    //method to add person to HashMap and print the list of persons with their hobbies and hobby addresses
    public void addPerson(Person newPerson, Hobby hobby, Address address) {
        List<Address> addresses = new LinkedList<>();
        addresses.add(new Address(address.getAddress()));
        HashMap<Hobby,List <Address>> hobbyMap = new HashMap<>();
        hobbyMap.put(new Hobby(hobby.getHobby()), addresses);
        HashMap<Person, HashMap<Hobby, List<Address>>> personMap = new LinkedHashMap<>();
        personMap.put(newPerson, hobbyMap);
        for(Person displayPerson : personMap.keySet()){
            System.out.println("Person name: " + displayPerson.getPersonName() + ", hobby: " + hobby.getHobby()
            + ", hobby address: " + address.getAddress());
        }
    }

}

