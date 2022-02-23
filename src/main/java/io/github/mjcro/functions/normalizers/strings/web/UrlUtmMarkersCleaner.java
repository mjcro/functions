package io.github.mjcro.functions.normalizers.strings.web;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Function;

/**
 * Removes UTM markers from given URL string.
 */
public class UrlUtmMarkersCleaner implements Function<String, String> {
    @Override
    public String apply(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        if (s.isEmpty()) {
            return s;
        }

        // Searching query parameters
        int pIndex = s.indexOf("?");
        if (pIndex < 0) {
            return s;
        }

        // Searching for anchor
        int aIndex = s.lastIndexOf("#");

        // Reading query parameters
        String body = aIndex == -1
                ? s.substring(pIndex)
                : s.substring(pIndex, aIndex);

        String[] chunks = body.split("[?&]");

        ArrayList<String> survivors = new ArrayList<>();
        for (String chunk : chunks) {
            if (chunk.isEmpty() || chunk.toLowerCase(Locale.ROOT).startsWith("utm_")) {
                continue;
            }

            survivors.add(chunk);
        }

        return s.substring(0, pIndex)
                + (survivors.isEmpty() ? "" : "?" + String.join("&", survivors))
                + (aIndex < 0 ? "" : s.substring(aIndex));
    }
}
