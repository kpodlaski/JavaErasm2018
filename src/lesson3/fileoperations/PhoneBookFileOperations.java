package lesson3.fileoperations;

import lesson3.model.Person;
import lesson3.model.PhoneBook;

import java.io.*;
import java.util.Arrays;

/**
 * Created by Krzysztof Podlaski on 19.04.2018.
 */
public class PhoneBookFileOperations {
    private String fileName;

    public PhoneBookFileOperations(String fileName) {
        this.fileName = fileName;
    }

    public void saveToFile(PhoneBook ph) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(fileName));
        for (Person p : ph.getPersons() ){
            String line = p.getName()+";"+p.getSurname()+";"+p.getTel();
            pw.println(line);
        }
        pw.close();
    }

    public PhoneBook readFromFile() throws IOException {
        BufferedReader br = new BufferedReader(
                new FileReader(
                new File(fileName)
                ));
        String line;
        PhoneBook ph = new PhoneBook();
        while( (line=br.readLine())!=null ){
            String arr[] = line.split(";");
            //System.out.println(Arrays.toString(arr));
            Person p = new Person(
                    arr[0],
                    arr[1],
                    Long.parseLong(arr[2])
                    );
            ph.add(p);
        }
        br.close();
        return ph;
    }
}
