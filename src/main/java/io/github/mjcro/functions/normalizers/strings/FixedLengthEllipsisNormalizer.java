package io.github.mjcro.functions.normalizers.strings;

import java.util.function.Function;

/**
 * Truncates string to requested length and appends ellipsis if
 * truncation occurs.
 * <p>
 * Guarantees that resulting string will not exceed threshold
 * (even with ellipsis)
 */
public class FixedLengthEllipsisNormalizer implements Function<String, String> {
    private final int threshold;

    /**
     * Constructs new normalizer.
     *
     * @param threshold Threshold string size.
     */
    public FixedLengthEllipsisNormalizer(int threshold) {
        if (threshold < 2) {
            throw new IllegalArgumentException(
                    "Illegal size threshold " + threshold + ". It should be at least 2"
            );
        }
        this.threshold = threshold;
    }

    @Override
    public String apply(String s) {
        if (s == null || s.length() <= threshold) {
            return s;
        }

        return s.substring(0, threshold - 1) + "…";
    }
}
