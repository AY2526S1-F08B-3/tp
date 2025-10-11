package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Subject object for a Person.
 */
public class Subject {
    public static final String MESSAGE_CONSTRAINTS = "Subject cannot be blank.";
    public static final String VALIDATION_REGEX = "[A-Za-z ]+";
    public final String subject;

    /**
     * Constructs a Subject object.
     * @param subject A valid Subject.
     */
    public Subject(String subject) {
        requireNonNull(subject);
        String s = subject.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        this.subject = s;
    }

    /**
     * Parses the given string into a {@code Subject}.
     *
     * @param text the input subject string
     * @return a {@code Subject} object
     * @throws IllegalArgumentException if the input is invalid
     */
    public static Subject parse(String text) {
        requireNonNull(text);
        String s = text.trim();
        if (!isValidSubject(s)) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        return new Subject(s);
    }

    public static boolean isValidSubject(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override public String toString() {
        return subject;
    }
    @Override public int hashCode() {
        return subject.hashCode();
    }
    @Override public boolean equals(Object o) {
        return (o == this) || (o instanceof Subject && subject.equals(((Subject) o).subject));
    }
}
