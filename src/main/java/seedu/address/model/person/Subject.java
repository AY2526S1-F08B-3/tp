package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

public class Subject {
    public static final String MESSAGE_CONSTRAINTS = "Subject cannot be blank.";
    public final String subject;

    public Subject(String subject) {
        requireNonNull(subject);
        String s = subject.trim();
        if (s.isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        this.subject = s;
    }

    @Override public String toString() { return subject; }
    @Override public int hashCode() { return subject.hashCode(); }
    @Override public boolean equals(Object o) {
        return (o == this) || (o instanceof Subject && subject.equals(((Subject) o).subject));
    }
}
