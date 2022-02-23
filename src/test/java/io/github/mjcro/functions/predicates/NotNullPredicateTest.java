package io.github.mjcro.functions.predicates;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NotNullPredicateTest {
    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {null, false},
                {true, true},
                {false, true},
                {0, true},
                {"", true},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testTest(Object given, boolean expected) {
        Assert.assertEquals(new NotNullPredicate().test(given), expected);
    }
}