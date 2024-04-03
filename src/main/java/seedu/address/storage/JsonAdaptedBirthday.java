package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.person.Birthday;

import java.time.LocalDate;

/**
 * Jackson-friendly version of {@link Birthday}.
 */
public class JsonAdaptedBirthday {

    private final String birthday;

    /**
     * Constructs a {@code JsonAdaptedBirthday} with the given {@code birthday}.
     */
    @JsonCreator
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
        return ParserUtil.parseBirthday(birthday);
    }
}
