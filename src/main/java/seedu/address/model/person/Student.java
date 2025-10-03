package seedu.address.model.person;

import seedu.address.model.tag.Tag;

import java.util.Set;

public class Student extends Person{

    private Tutor matchedTutor;

    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param tags
     */
    public Student(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Subject subject, Level level,
                   Price price ) {
        super(name, phone, email, address, tags, subject, level, price);
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
