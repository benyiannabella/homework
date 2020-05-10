package homework4;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertNull;

class CompareNameTest {

    @Test
    public void compare_p1_name_null(){
        Comparator<Person> compareName = new CompareAge();
        Person p1 = new Person(null, 20);
        Person p2 = new Person("Dean Parker", 20);
        compareName.compare(p1,p2);
        assertNull(null);
    }

    @Test
    public void compare_p2_name_null(){
        Comparator<Person> compareName = new CompareAge();
        Person p1 = new Person("Jane Doe", 20);
        Person p2 = new Person(null, 20);
        compareName.compare(p1,p2);
        assertNull(null);
    }

}