package Hw1Q2;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class MyMain {
    public LinkedList<Person> people = new LinkedList<>();

    public void store(InputStream in, LinkedList<Person> people) {
        Scanner sc = new Scanner(in);

        String id;
        String firstName;
        String lastName;

        while (sc.hasNext()) {
            id = sc.next();

            if (!sc.hasNext()) break;
            firstName = sc.next();

            if (!sc.hasNext()) break;
            lastName = sc.next();

            Person person = new Person(id, firstName, lastName);
            people.add(person);
        }

        sc.close();

    }

    public void display(OutputStream out, LinkedList<Person> people) {
        Iterator<Person> tail = people.iterator();
        
        while (tail.hasNext()) {
            Person person = tail.next();
            String line = person.toString() + "\n";

            try {
                out.write(line.getBytes(StandardCharsets.UTF_8));

            } catch (IOException e) {
                throw new RuntimeException("Failed to write person", e);
            }
        }

    }

    public int find(String sid, LinkedList<Person> people) {
        Iterator<Person> tail = people.iterator();
        int count = 0;

        while (tail.hasNext()) {
            Person person = tail.next();
            count = count + 1;

            if (person.getId() == sid) {
                return count;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        try {
            File peopleFile = new File("people.txt");
            InputStream in = new FileInputStream(peopleFile);

            MyMain mainProgram = new MyMain();

            mainProgram.store(in, mainProgram.people);
            mainProgram.display(System.out, mainProgram.people);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }
}
