package seedu.address.model.person;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Student in the application.
 * <p>
 * A Student is a type of {@link Person} with additional attributes
 * relevant to tuition matching, such as subject, level, price, and
 * a reference to a matched tutor (if any).
 * <p>
 * Inherits all general person details (e.g., name, phone, email, address, tags)
 * from the {@code Person} superclass.
 */
public class Student extends Person {

    private Tutor matchedTutor;
    private Subject subject;
    private Level level;
    private Price price;

    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param subject
     * @param level
     * @param price
     * @param tags
     */
    public Student(Name name, Phone phone, Email email, Address address, Subject subject, Level level, Price price,
                   Set<Tag> tags) {
        super(name, phone, email, address, tags);
        this.subject = subject;
        this.level = level;
        this.price = price;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    /**
     * Sets the matched tutor for this object.
     * <p>
     * Calling this method updates the reference to the {@code matchedTutor}
     * that is currently paired with this entity. It is typically used when
     * establishing or updating a match between a student and a tutor.
     *
     * @param matchedTutor the {@link Tutor} object to be associated as the match
     */
    public void setMatchedTutor(Tutor matchedTutor) {
        this.matchedTutor = matchedTutor;
    }
}
