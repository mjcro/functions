package io.github.mjcro.functions.converters.numbers;

import java.time.Instant;
import java.util.function.Function;

/**
 * Converts Unix timestamp in seconds into java {@link Instant}.
 */
public class NumberUnixSecondsToInstantConverter implements Function<Number, Instant> {
    @Override
    public Instant apply(Number number) {
        return number == null ? null : Instant.ofEpochSecond(number.longValue());
    }
}
