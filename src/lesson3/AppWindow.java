package lesson3;

import lesson3.fileoperations.PhoneBookFileOperations;
import lesson3.model.Person;
import lesson3.model.PhoneBook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Krzysztof Podlaski on 26.04.2018.
 */
public class AppWindow {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JPanel firstPane;
    private JPanel secondPanel;
    private JTable table1;
    private JTextField nameTextField;
    private JTextField telTextField;
    private JButton addButton;
    private JTextField surnameTextField;
    private JButton saveToFileButton;
    private PhoneBook phoneBook;
    private DefaultTableModel tableModel;


    public AppWindow() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Person p =
                new Person(nameTextField.getText(),
                        surnameTextField.getText(),
                        Long.parseLong(telTextField.getText()));
                phoneBook.add(p);
                Object[] row = new Object[3];
                row[0] = p.getName();
                row[1] = p.getSurname();
                row[2] = p.getTel();
                tableModel.addRow(row);

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AppWindow");
        AppWindow appWindow =new AppWindow();
        appWindow.tabbedPane1.setTitleAt(0,"Main Tab");
        appWindow.tabbedPane1.setTitleAt(1,"Detail Tab");

        frame.setContentPane(appWindow.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        //appWindow.fillTheData();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] columnNames=
        new String[] {"Name", "Surname", "Telephone"};
        this.phoneBook = readTheData();
        tableModel = new DefaultTableModel(0,0);
        tableModel.setColumnIdentifiers(columnNames);
        table1 = new JTable();
        table1.setModel(tableModel);
        for(Person p : phoneBook.getPersons()) {
            Object[] row = new Object[3];
            row[0] = p.getName();
            row[1] = p.getSurname();
            row[2] = p.getTel();
            tableModel.addRow(row);
        }
    }
    private PhoneBook readTheData(){
        PhoneBookFileOperations file =
        new PhoneBookFileOperations("phones.txt");
        PhoneBook ph=null;
        try {
            ph = file.readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return ph;
    }
}
