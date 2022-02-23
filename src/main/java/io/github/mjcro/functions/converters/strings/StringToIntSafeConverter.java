package io.github.mjcro.functions.converters.strings;

import java.util.function.Function;

/**
 * Transforms given string value into Integer.
 * Will return null on exception.
 */
public class StringToIntSafeConverter implements Function<String, Integer> {
    @Override
    public Integer apply(String s) {
        try {
            return s == null || s.isEmpty() ? null : Integer.parseInt(s);
        } catch (NumberFormatException ignore) {
            return null;
        }
    }
}
