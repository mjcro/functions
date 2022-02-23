package io.github.mjcro.functions.normalizers.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Function;

public class StringTrimNormalizerTest {
    private final Function<String, String> normalizer = new StringTrimNormalizer();

    @DataProvider
    public Object[][] normalizeDataProvider() {
        return new Object[][]{
                {null, null},
                {"", ""},
                {"\r\n\t ", ""},
                {"\rHello \t\n", "Hello"},
        };
    }

    @Test(dataProvider = "normalizeDataProvider")
    public void testApply(String given, String expected) {
        Assert.assertEquals(normalizer.apply(given), expected);
    }
}