// Create a Couple class that contains to Person objects one for the bride and one for the groom
public class Couple {
    public Person bride;
    public Person groom;

    // Constructor method that requires a person argument for both the bride and the groom
    public Couple (Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }

    // A get method that returns the bride object
    public Person getBride() {
        return bride;
    }

    // A get method that returns the groom object
    public Person getGroom() {
        return groom;
    }
}
