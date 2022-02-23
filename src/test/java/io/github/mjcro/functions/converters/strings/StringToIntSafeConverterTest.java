package io.github.mjcro.functions.converters.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringToIntSafeConverterTest {
    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {null, null},
                {"", null},
                {"af", null},
                {"18 ", null},
                {" 18", null},
                {"1.8", null},
                {"+122", 122},
                {"-350", -350},
                {"42", 42}
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testApply(String given, Integer expected) {
        Assert.assertEquals(new StringToIntSafeConverter().apply(given), expected);
    }
}