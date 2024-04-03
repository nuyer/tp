package seedu.address.model.person;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Birthday {

    public static final String MESSAGE_INVALID_DATE_FORMAT =
            "Invalid date format. Date should be in the format dd-MM-yyyy.";
    public static final String MESSAGE_INVALID_DATE = "Employee must be at least "
            + Birthday.MAXIMUM_AGE + " years old and less than " + Birthday.MAXIMUM_AGE + " years old.";
    private static final int MINIMUM_AGE = 10;
    private static final int MAXIMUM_AGE = 100;

    private final LocalDate date;

    public Birthday() {
        this.date = null;
    }

    public Birthday(LocalDate date) {
        this.date = date;
    }

    public Birthday(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = LocalDate.parse(date, formatter);
    }

    public LocalDate getDate() {
        return date;
    }


    public static boolean isValidBirthday(LocalDate birthday) {
        if (birthday == null) {
            return false;
        }

        LocalDate today = LocalDate.now();
        Period period = Period.between(birthday, today);
        int age = period.getYears();

        return (age >= MINIMUM_AGE) && (age <= MAXIMUM_AGE);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Birthday)) {
            return false;
        }

        Birthday otherBirthday = (Birthday) other;
        return otherBirthday.getDate().equals(getDate());
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }
}
