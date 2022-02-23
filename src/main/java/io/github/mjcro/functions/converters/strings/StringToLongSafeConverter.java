package io.github.mjcro.functions.converters.strings;

import java.util.function.Function;

/**
 * Transforms given string value into Long.
 * Will return null on exception.
 */
public class StringToLongSafeConverter implements Function<String, Long> {
    @Override
    public Long apply(String s) {
        try {
            return s == null || s.isEmpty() ? null : Long.parseLong(s);
        } catch (NumberFormatException ignore) {
            return null;
        }
    }
}
