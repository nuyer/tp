package seedu.address.model.person;

import java.time.LocalDate;
import java.time.Period;

public class Birthday {

    public static final String MESSAGE_INVALID_DATE_FORMAT = "Skills should only contain alphanumeric characters and spaces";
    public static final String MESSAGE_INVALID_DATE = "Skills should only contain alphanumeric characters and spaces";
    private static final int MINIMUM_AGE = 10;
    private static final int MAXIMUM_AGE = 10;

    private final LocalDate date;

    public Birthday() {
        this.date = null;
    }

    public Birthday(LocalDate date) {
        this.date = date;
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

        return age >= MINIMUM_AGE && age < MAXIMUM_AGE;
    }

    @Override
    public String toString() {
        return date.toString();
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
