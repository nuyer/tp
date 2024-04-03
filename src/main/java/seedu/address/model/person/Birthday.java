package seedu.address.model.person;

import java.util.Calendar;
import java.util.Date;

public class Birthday {

    public static final String MESSAGE_INVALID_DATE_FORMAT = "Skills should only contain alphanumeric characters and spaces";
    public static final String MESSAGE_INVALID_DATE = "Skills should only contain alphanumeric characters and spaces";
    private static final int MINIMUM_AGE = 10;
    private static final int MAXIMUM_AGE = 10;

    private final Date date;

    public Birthday() {
        this.date = null;
    }

    public Birthday(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }


    public static boolean isValidBirthday(Date birthday) {
        if (birthday == null) {
            return false;
        }

        Calendar dob = Calendar.getInstance();
        dob.setTime(birthday);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH) ||
                (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH) && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }

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
