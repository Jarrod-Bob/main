package seedu.eylah.diettracker.model.self;

import java.util.Objects;

import seedu.eylah.diettracker.model.Mode;

/**
 *  A default Self stub that have all of the methods failing.
 */
public class SelfStub extends Self {
    // Data fields
    private Height height;
    private Weight weight;
    private Mode mode;

    public Height getHeight() {
        return height;
    }

    public Weight getWeight() {

        return weight;
    }

    public Mode getMode() {
        return mode;
    }

    public void setHeight(Height newHeight) {
        height = newHeight;
    }

    public void setWeight(Weight newWeight) {
        weight = newWeight;
    }

    public void setMode(Mode newMode) {
        mode = newMode;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(height, weight, mode);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Height: ")
                .append(getHeight())
                .append(" Weight: ")
                .append(getWeight())
                .append(" Mode: ")
                .append(getMode());
        return builder.toString();
    }
}
