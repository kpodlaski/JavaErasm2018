package lesson3.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Krzysztof Podlaski on 19.04.2018.
 */
public class PhoneBook {
    private List<Person> persons;

    public PhoneBook(){
        persons=new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public boolean add(Person person) {
        return persons.add(person);
    }

    public boolean contains(Object o) {
        return persons.contains(o);
    }

    public Person get(int index) {
        return persons.get(index);
    }

    public Person remove(int index) {
        return persons.remove(index);
    }
}
