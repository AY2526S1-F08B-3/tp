package seedu.address.model.person;

import seedu.address.model.tag.Tag;

import java.util.Set;

public class Tutor extends Person{

    private Student matchedStudent;

    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param tags
     */
    public Tutor(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Subject subject, Level level,
                   Price price ) {
        super(name, phone, email, address, tags, subject, level, price);
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

