// Create a Person class that contains a string for their first and last name
public class Person {
    public String first;
    public String last;

    // Constructor method that requires a string argument for both the first and last name
    public Person (String first, String last) {
        this.first = first;
        this.last = last;
    }

    // A get method that returns the person's first name
    public String getFirst() {
        return first;
    }

    // A get method that returns the person's last name
    public String getLast() {
        return last;
    }
}
