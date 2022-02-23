package io.github.mjcro.functions.normalizers.strings;

import java.util.function.Function;

/**
 * Removes whitespace character at start and end of string.
 */
public class StringTrimNormalizer implements Function<String, String> {
    @Override
    public String apply(String s) {
        return s == null || s.isEmpty() ? s : s.trim();
    }
}
