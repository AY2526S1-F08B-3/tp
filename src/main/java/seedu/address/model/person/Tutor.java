package seedu.address.model.person;

import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Tutor in the  application.
 * <p>
 * A Tutor is a type of {@link Person} with additional attributes
 * relevant to tuition matching, such as subject expertise, the
 * education levels they can teach, hourly price, and a reference
 * to a matched student (if any).
 * <p>
 * Inherits all general person details (e.g., name, phone, email, address, tags)
 * from the {@code Person} superclass.
 */
public class Tutor extends Person {

    private Student matchedStudent;
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
    public Tutor(Name name, Phone phone, Email email, Address address, Subject subject, Level level, Price price,
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
     * Sets the matched student for this object.
     * <p>
     * Calling this method updates the reference to the {@code matchedStudent}
     * that is currently paired with this tutor. It is typically used when
     * establishing or updating a match between a tutor and a student.
     *
     * @param matchedStudent the {@link Student} object to be associated as the match
     */
    public void setMatchedStudent(Student matchedStudent) {
        this.matchedStudent = matchedStudent;
    }
}

