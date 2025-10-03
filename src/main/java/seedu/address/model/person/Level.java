package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

public class Level {
    public static final String MESSAGE_CONSTRAINTS =
            "Level must be a positive integer or a range start-end (e.g., 3 or 1-6) with start <= end.";
    public static final String VALIDATION_REGEX = "\\d+|\\d+\\s*-\\s*\\d+";

    private final int start; // inclusive
    private final int end;   // inclusive

    public Level(int start, int end) {
        if (start <= 0 || end <= 0 || start > end) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        this.start = start;
        this.end = end;
    }

    public static boolean isValidLevel(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /** Accepts "3", "03", "3-3", "1-6" (spaces allowed around '-'). */
    public static Level parse(String text) {
        requireNonNull(text);
        String s = text.trim();
        // Single value?
        if (s.matches("\\d+")) {
            int v = Integer.parseInt(s);
            return new Level(v, v);
        }
        // Range?
        if (s.matches("\\d+\\s*-\\s*\\d+")) {
            String[] parts = s.split("-");
            int a = Integer.parseInt(parts[0].trim());
            int b = Integer.parseInt(parts[1].trim());
            return new Level(a, b);
        }
        throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
    }

    /** True if this range covers the other (e.g., tutor covers student). */
    public boolean includes(Level other) {
        return this.start <= other.start && this.end >= other.end;
    }

    public boolean isSingle() { return start == end; }

    /** Store compactly: "3" if single, else "1-6". */
    @Override public String toString() {
        return isSingle() ? Integer.toString(start) : (start + "-" + end);
    }

    @Override public int hashCode() { return 31 * start + end; }
    @Override public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Level)) return false;
        Level other = (Level) o;
        return start == other.start && end == other.end;
    }
}