package io.github.mjcro.functions.converters.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringToLongSafeConverterTest {
    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {null, null},
                {"", null},
                {"af", null},
                {"18 ", null},
                {" 18", null},
                {"1.8", null},
                {"+122", 122L},
                {"-350", -350L},
                {"42", 42L}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testApply(String given, Long expected) {
        Assert.assertEquals(new StringToLongSafeConverter().apply(given), expected);
    }
}