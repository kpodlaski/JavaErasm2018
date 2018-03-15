package lesson1;

/**
 * Created by Krzysztof Podlaski on 15.03.2018.
 */
public class Person {
    private String name;
    private String surname;
    private long insurranceId;

    public Person(String name, String surname)  {
        System.out.println("Constructor started");
        System.out.println("name "+this.name);
        System.out.println("surname "+this.surname);
        System.out.println("iId "+this.insurranceId);
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname,long iId){
        this(name,surname);
        this.insurranceId=iId;
    }
    public static void main(String[] args) {
        Person p =
           new Person("Jane","Doe");
        p = new Person("Jane",
                "Doe",123123123L);
        Person table[] = new Person[3];
        for(int i=0; i< table.length;i++){
            table[i] = new Person("A"+i,
                    "B"+i,i);
        }
        System.out.println(table[1].getName());
        String name = table[1].getName();
        for(int i=0; i<name.length();i++){
            System.out.print(name.charAt(i));
            System.out.print(" => ");
            System.out.println((int) name.charAt(i));
        }

    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    public long getInsurranceId() {
        return insurranceId;
    }

    private void setInsurranceId(long insurranceId) {
        this.insurranceId = insurranceId;
    }
}
