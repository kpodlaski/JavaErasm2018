package lesson3;

import lesson3.fileoperations.PhoneBookFileOperations;
import lesson3.model.Person;
import lesson3.model.PhoneBook;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Krzysztof Podlaski on 19.04.2018.
 */
public class Main {
    public static void main(String[] args) {
        PhoneBook ph = new PhoneBook();
        Person p = new Person("Anna",
                        "Summerson",
                        48123123123L);
        ph.add(p);
        p = new Person("Thomas",
                "Thompson",
                48321123123L);
        ph.add(p);
        System.out.println(ph.getPersons());
        System.out.println("=====================");
        System.out.println(ph.getPersons().get(1));
        p = new Person("Thomas",
                "Thompson",
                48321123123L);
        //ph.getPersons().remove(p);
        System.out.println(ph.getPersons().contains(p));

        PhoneBookFileOperations file =
                new PhoneBookFileOperations("phones.txt");
        PhoneBook ph2=null;
        try {
            file.saveToFile(ph);
            System.out.println("File Saved");
            ph2 = file.readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ph2.getPersons());
    }
}
