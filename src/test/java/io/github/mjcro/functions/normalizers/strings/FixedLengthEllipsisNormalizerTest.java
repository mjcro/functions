package io.github.mjcro.functions.normalizers.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FixedLengthEllipsisNormalizerTest {
    @DataProvider
    public Object[][] normalizeDataProvider() {
        return new Object[][]{
                {5, null, null},
                {5, "", ""},
                {5, "foo", "foo"},
                {2, "foo", "f…"},
                {4, "  foo", "  f…"},
                {5, "Independence", "Inde…"},
        };
    }

    @Test(dataProvider = "normalizeDataProvider")
    public void testApply(int threshold, String given, String expected) {
        Assert.assertEquals(new FixedLengthEllipsisNormalizer(threshold).apply(given), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalThreshold() {
        new FixedLengthEllipsisNormalizer(1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegalThresholdZero() {
        new FixedLengthEllipsisNormalizer(0);
    }
}