package io.github.mjcro.functions.predicates;

import java.util.function.Predicate;

/**
 * Predicate that returns true only if given object is not null.
 */
public class NotNullPredicate implements Predicate<Object> {
    @Override
    public boolean test(Object o) {
        return o != null;
    }
}
