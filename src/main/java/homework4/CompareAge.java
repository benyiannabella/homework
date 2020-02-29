package homework4;

import java.util.Comparator;

public class CompareAge implements Comparator<Person>{

    //override the compare method of the Comparator interface
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getPersonAge() > p2.getPersonAge()) return 1;
        if (p1.getPersonAge() < p2.getPersonAge()) return -1;
        else return 0;
    }
}
