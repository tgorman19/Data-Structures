// Import the LocalDate class
import java.time.LocalDate;

// Create a Wedding class that contains a string for the location, a couple object for the couple, and a LocalDate for the date
public class Wedding {
    public String location;
    public Couple couple;
    public LocalDate date;

    // Constructor method that requires a string argument, a couple argument, and a LocalDate argument
    public Wedding (String location, Couple couple, LocalDate date) {
        this.location = location;
        this.couple = couple;
        this.date = date;
    }

    // A get method that returns the couple object
    public Couple getCouple() {
        return couple;
    }

    // A get method that returns the location string
    public String getLocation() {
        return location;
    }

    // A get method that returns the date LocalDate
    public LocalDate getDate() {
        return date;
    }

}

