package io.github.mjcro.functions.normalizers.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmojiRegexCleanerTest {
    @DataProvider
    public Object[][] normalizeDataProvider() {
        return new Object[][]{
                {null, null},
                {"", ""},
                {"foo", "foo"},
                {"\uD83D\uDCAA", ""},
                {"♾️❤ Hello, world! ❤️", " Hello, world! "},
        };
    }

    @Test(dataProvider = "normalizeDataProvider")
    public void testApply(String given, String expected) {
        Assert.assertEquals(new EmojiRegexCleaner().apply(given), expected);
    }
}