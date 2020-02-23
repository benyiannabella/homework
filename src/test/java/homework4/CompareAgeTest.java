package homework4;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

class CompareAgeTest {
    CompareAge compareAge;
    Person p1;
    Person p2;

    @Test
    public void compare_if_same_age(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Jane Doe", 20);
        Person p2 = new Person("Dean Parker", 20);
        assertEquals(0,compareAge.compare(p1,p2));
    }

    @Test
    public void compare_if_p1age_grater_than_p2age(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Jane Doe", 32);
        Person p2 = new Person("Dean Parker", 20);
        assertEquals(1, compareAge.compare(p1,p2));
    }

    @Test
    public void compare_if_p1age_less_than_p2age(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Jane Doe", 20);
        Person p2 = new Person("Dean Parker", 32);
        assertEquals(-1, compareAge.compare(p1,p2));
    }

    @Test
    public void compare_if_p2age_greater_than_p1age(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Jane Doe", 20);
        Person p2 = new Person("Dean Parker", 32);
        assertEquals(1, compareAge.compare(p2,p1));
    }

    @Test
    public void compare_if_p2age_less_than_p1age(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Jane Doe", 32);
        Person p2 = new Person("Dean Parker", 20);
        assertEquals(-1, compareAge.compare(p2,p1));
    }

    @Test
    public void compare_if_p2age_missing(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Jane Doe", 32);
        Person p2 = new Person("Dean Parker", 0);
        assertEquals(-1, compareAge.compare(p2,p1));
    }

    @Test
    public void compare_if_p1age_missing(){
        Comparator<Person> compareAge = new CompareAge();
        Person p1 = new Person("Jane Doe", 0);
        Person p2 = new Person("Dean Parker", 20);
        assertEquals(1, compareAge.compare(p2,p1));
    }
}