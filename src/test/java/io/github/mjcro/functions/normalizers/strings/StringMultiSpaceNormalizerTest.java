package io.github.mjcro.functions.normalizers.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.Function;

public class StringMultiSpaceNormalizerTest {
    private final Function<String, String> normalizer = new StringMultiSpaceNormalizer();

    @DataProvider
    public Object[][] normalizeDataProvider() {
        return new Object[][]{
                {null, null},
                {"", ""},
                {"\r\n\t ", " "},
                {"This has  more    spaces", "This has more spaces"},
        };
    }

    @Test(dataProvider = "normalizeDataProvider")
    public void testApply(String given, String expected) {
        Assert.assertEquals(normalizer.apply(given), expected);
    }
}