package seedu.address.logic.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Birthday;
import seedu.address.model.person.Employee;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;

/**
 * The `BirthdayReminder` class checks for employees whose birthday is today and generates a reminder text to
 * wish them a happy birthday.
 */
public class BirthdayReminder {

    private final UniquePersonList persons;

    public BirthdayReminder(UniquePersonList persons) {
        this.persons = persons;
    }

    /**
     * The function `checkBirthdayAndRemind` retrieves a list of names of people with upcoming birthdays, builds
     * a reminder text, and connects to the UI to display the reminder.
     */
    public void checkBirthdayAndRemind() {
        List<String> birthdayPeopleNames = getBirthdayPeopleNames();
        if (!birthdayPeopleNames.isEmpty()) {
            String reminderText = buildReminderText(birthdayPeopleNames);
            //connect to UI to show reminder
        }
    }

    /**
     * The function `getBirthdayPeopleNames` retrieves the names of employees whose birthday is today from a list
     * of persons.
     *
     * @return A list of string arrays representing People's Name whose birthday is today
     */
    private List<String> getBirthdayPeopleNames() {
        List<String> birthdayPeopleNames = new ArrayList<>();
        for (Person person : persons) {
            if (person instanceof Employee) {
                Employee emp = (Employee) person;
                Birthday birthday = emp.getBirthday();
                if (isBirthdayToday(birthday)) {
                    birthdayPeopleNames.add(person.getName().toString());
                }
            }
        }
        return birthdayPeopleNames;
    }

    /**
     * The function `isBirthdayToday` checks if the given `Birthday` object falls on the current date.
     *
     * @param birthday ```java
     * @return The method is returning a boolean value indicating whether the provided birthday object represents
     *     today's date.
     */
    private boolean isBirthdayToday(Birthday birthday) {
        LocalDate today = LocalDate.now();
        int birthdayMonth = birthday.getDate().getMonthValue();
        int birthdayDayOfMonth = birthday.getDate().getDayOfMonth();
        int currentMonth = today.getMonthValue();
        int currentDayOfMonth = today.getDayOfMonth();

        return (birthdayMonth == currentMonth) && (birthdayDayOfMonth == currentDayOfMonth);
    }

    /**
     * The function builds a reminder text for wishing happy birthday to people whose names are provided in a
     *     list.
     *
     * @param birthdayPeopleNames List of String birthdayPeopleNames
     * @return The method `buildReminderText` returns a String that contains a reminder text for today's
     *     birthdays, including the names of the people whose birthdays are today.
     */
    private String buildReminderText(List<String> birthdayPeopleNames) {
        StringBuilder reminderText = new StringBuilder();
        reminderText.append("Today's someone's birthday!\n");
        reminderText.append("Wish a happy birthday to: \n");
        for (String name : birthdayPeopleNames) {
            reminderText.append("- ").append(name).append("\n");
        }
        return reminderText.toString();
    }
}
