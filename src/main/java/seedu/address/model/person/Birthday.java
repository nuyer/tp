package seedu.address.model.person;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * Represents an Employee's birthday in the address book.
 * Guarantees: immutable; is valid as declared in
 */
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

    /**
     * Constructs a {@code Birthday} object with the given date represented as a {@code String}.
     * The date should be in the format "dd-MM-yyyy".
     *
     * @param date A {@code String} representing the date in the format "dd-MM-yyyy".
     */
    public Birthday(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = LocalDate.parse(date, formatter);
    }

    /**
     * The function `getDate` returns a `LocalDate` object.
     *
     * @return A `LocalDate` object is being returned.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * The function `isValidBirthday` checks if a given `LocalDate` represents a valid birthday within a
     *     specified age range.
     *
     * @param birthday The `isValidBirthday` method is used to check if a given `LocalDate` object represents a
     *     valid birthday within a specified age range. The method calculates the age based on the difference between
     *     the provided birthday and the current date, and then checks if the age falls within the defined `MINIMUM_A
     * @return The method `isValidBirthday` returns a boolean value indicating whether the provided birthday is
     *     valid based on the minimum and maximum age constraints.
     */
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
        if (date == null) {
            return "";
        }
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
