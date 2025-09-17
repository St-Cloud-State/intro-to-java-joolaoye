package Hw1Q3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
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
}
