package homework4;

import java.util.Comparator;

public class CompareName implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getPersonName().compareTo(p2.getPersonName());
    }
}