package io.github.mjcro.functions.normalizers.strings;

import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Removes all emoji from given string using regex.
 */
public class EmojiRegexCleaner implements Function<String, String> {
    private final Pattern pattern = Pattern.compile(
            "[^\\p{L}\\p{N}\\p{P}\\p{Z}]",
            Pattern.UNICODE_CHARACTER_CLASS
    );

    @Override
    public String apply(final String s) {
        return s == null || s.isEmpty() ? s : pattern.matcher(s).replaceAll("");
    }
}
