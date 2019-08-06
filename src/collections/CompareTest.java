package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;

class Person implements Comparable<Person> {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}

public class CompareTest {
    public static void main(String[] args) {
        Person p1 = new Person("haha");
        Person p2 = new Person("aa");
        Person p3 = new Person("zz");

        ArrayList<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Collections.sort(list);

        for (Person p : list) {
            System.out.println(p.getName());
        }
    }
}
