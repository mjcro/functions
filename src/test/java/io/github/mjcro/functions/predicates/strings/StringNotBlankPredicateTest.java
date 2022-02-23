package io.github.mjcro.functions.predicates.strings;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringNotBlankPredicateTest {
    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {null, false},
                {"", false},
                {" ", false},
                {"\r\n\t ", false},
                {"foo", true},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testTest(String given, boolean expected) {
        Assert.assertEquals(new StringNotBlankPredicate().test(given), expected);
    }
}