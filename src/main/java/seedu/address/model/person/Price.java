package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents an hourly rate (in integer dollars) as either a single value or a range [min..max], inclusive.
 * Examples: "35", "30-45".
 */
public class Price {
    public static final String MESSAGE_CONSTRAINTS =
            "Price must be a non-negative integer or a range min-max (e.g., 35 or 30-45) with min <= max.";

    private final int min; // inclusive
    private final int max; // inclusive

    public Price(int min, int max) {
        if (min < 0 || max < 0 || min > max) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        this.min = min;
        this.max = max;
    }

    /** Accepts "35", "035", "35-35", "30-45" (spaces allowed around '-') */
    public static Price parse(String text) {
        requireNonNull(text);
        String s = text.trim();
        if (s.matches("\\d+")) {
            int v = Integer.parseInt(s);
            return new Price(v, v);
        }
        if (s.matches("\\d+\\s*-\\s*\\d+")) {
            String[] parts = s.split("-");
            int a = Integer.parseInt(parts[0].trim());
            int b = Integer.parseInt(parts[1].trim());
            return new Price(a, b);
        }
        throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
    }

    /** True if this price range fully covers the other. Useful for checking budget ⊆ tutor price range, etc. */
    public boolean includes(Price other) {
        return this.min <= other.min && this.max >= other.max;
    }

    /** True if the ranges intersect at all. Useful for quick compatibility checks. */
    public boolean overlaps(Price other) {
        return this.min <= other.max && other.min <= this.max;
    }

    /** True if a single value falls within this range. */
    public boolean includesSingle(int value) {
        return value >= min && value <= max;
    }

    public boolean isSingle() { return min == max; }

    @Override public String toString() {
        return isSingle() ? Integer.toString(min) : (min + "-" + max);
    }

    @Override public int hashCode() { return 31 * min + max; }
    @Override public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Price)) return false;
        Price other = (Price) o;
        return this.min == other.min && this.max == other.max;
    }
}