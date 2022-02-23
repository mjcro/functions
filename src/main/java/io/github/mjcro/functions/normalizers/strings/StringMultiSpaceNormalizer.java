package io.github.mjcro.functions.normalizers.strings;

import java.util.function.Function;

/**
 * Normalizer that will convert multiple sequential spaces into single one.
 * Example:
 * one...two...threw -> one.two.three
 */
public class StringMultiSpaceNormalizer implements Function<String, String> {
    @Override
    public String apply(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s.length());
        boolean space = false;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (space) {
                    // Skip
                    continue;
                }

                space = true;
                sb.append(' ');
            } else {
                space = false;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
