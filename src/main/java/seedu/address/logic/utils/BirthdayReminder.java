package seedu.address.logic.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import seedu.address.model.person.Birthday;
import seedu.address.model.person.Employee;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;

public class BirthdayReminder {

    private final UniquePersonList persons;

    public BirthdayReminder (UniquePersonList persons) {
        this.persons = persons;
    }
    public void checkBirthdayAndRemind() {
        List<String> birthdayPeopleNames = getBirthdayPeopleNames();
        if (!birthdayPeopleNames.isEmpty()) {
            String reminderText = buildReminderText(birthdayPeopleNames);
            //connect to UI to show reminder
        }
    }

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

    private boolean isBirthdayToday(Birthday birthday) {
        LocalDate today = LocalDate.now();
        int birthdayMonth = birthday.getDate().getMonthValue();
        int birthdayDayOfMonth = birthday.getDate().getDayOfMonth();
        int currentMonth = today.getMonthValue();
        int currentDayOfMonth = today.getDayOfMonth();

        return (birthdayMonth == currentMonth) && (birthdayDayOfMonth == currentDayOfMonth);
    }

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
