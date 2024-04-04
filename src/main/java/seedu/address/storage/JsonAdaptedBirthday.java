package seedu.address.storage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Birthday;

/**
 * Jackson-friendly version of {@link Birthday}.
 */
public class JsonAdaptedBirthday {

    private final String birthday;

    /**
     * Constructs a {@code JsonAdaptedBirthday} with the given {@code birthday}.
     */
    public JsonAdaptedBirthday() {
        this.birthday = "";
    }

    public JsonAdaptedBirthday(String birthday) {
        this.birthday = birthday;
    }

    public JsonAdaptedBirthday(Birthday birthday) {
        this.birthday = birthday.toString();
    }

    public String getBirthday() {
        return birthday;
    }

    /**
     * Converts this Jackson-friendly adapted birthday object into the model's {@code Birthday} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted birthday.
     */
    public Birthday toModelType() throws IllegalValueException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(birthday, formatter);
        return new Birthday(parsedDate);
    }
}
