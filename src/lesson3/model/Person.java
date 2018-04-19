package lesson3.model;

/**
 * Created by Krzysztof Podlaski on 19.04.2018.
 */
public class Person {
    private String name;
    private String surname;
    private long tel;

    public Person(){
        this("John","Doe",0);
    }

    public Person(String name, String surname, long tel) {
        this.name = name;
        this.surname = surname;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return name + ' ' + surname + " : +" +tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (tel != person.tel) return false;
        if (!name.equals(person.name)) return false;
        return surname.equals(person.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + (int) (tel ^ (tel >>> 32));
        return result;
    }
}
