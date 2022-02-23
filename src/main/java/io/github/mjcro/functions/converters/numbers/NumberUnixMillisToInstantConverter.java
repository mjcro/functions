package io.github.mjcro.functions.converters.numbers;

import java.time.Instant;
import java.util.function.Function;

/**
 * Converts Unix timestamp in milliseconds into java {@link Instant}.
 */
public class NumberUnixMillisToInstantConverter implements Function<Number, Instant> {
    @Override
    public Instant apply(Number number) {
        return number == null ? null : Instant.ofEpochMilli(number.longValue());
    }
}
