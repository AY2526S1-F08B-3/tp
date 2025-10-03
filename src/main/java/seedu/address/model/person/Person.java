package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

import javax.security.auth.Subject;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private final Set<Tag> tags = new HashSet<>();
    private Subject subject;
    private Level level;
    private Price price;
    private boolean isMatched = false;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, Phone phone, Email email, Address address, Set<Tag> tags, Subject subject, Level level,
                  Price price) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.subject = subject;
        this.level = level;
        this.price = price;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public Subject getSubject() {
        return subject;
    }

    public Level getLevel() {
        return level;
    }

    public Price getPrice() {
        return price;
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
    }

    /**
     * Marks this object as matched.
     * <p>
     * Calling this method will set the {@code isMatched} flag to {@code true}.
     * It is typically used when the object has been successfully paired or
     * linked with another entity.
     */
    public void match() {
        this.isMatched = true;
    }

    /**
     * Marks this object as unmatched.
     * <p>
     * Calling this method will set the {@code isMatched} flag to {@code false}.
     * It is typically used when the object is no longer paired or
     * linked with another entity.
     */
    public void unmatch() {
        this.isMatched = false;
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return name.equals(otherPerson.name)
                && phone.equals(otherPerson.phone)
                && email.equals(otherPerson.email)
                && address.equals(otherPerson.address)
                && subject.equals(otherPerson.subject)
                && level.equals(otherPerson.level)
                && price.equals(otherPerson.price)
                && tags.equals(otherPerson.tags);

    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address, subject, level, price, tags);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("subject", subject)
                .add("level", level)
                .add("price", price)
                .add("tags", tags)
                .toString();
    }
}
