package Hw1Q3;

public class Person {
    String id;
    String firstName;
    String lastName;

    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override public String toString() {
        String output = "User ID: %s First Name: %s Last Name: %s".
            formatted(this.id, this.firstName, this.lastName);

        return output;
    }

    public static void main(String[] args) {

    }
}
