package io.github.mjcro.functions.predicates.strings;

import java.util.function.Predicate;

/**
 * Predicate that returns true only if given string is not null
 * and is not empty and not blank.
 */
public class StringNotBlankPredicate implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s != null && !s.isEmpty() && s.equals(s.trim());
    }
}
