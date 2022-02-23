package io.github.mjcro.functions.converters.numbers;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Instant;

public class NumberUnixMillisToInstantConverterTest {
    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {null, null},
                {15, Instant.ofEpochMilli(15)},
                {-42, Instant.ofEpochMilli(-42)},
                {3502L, Instant.ofEpochMilli(3502L)},
                {324234.1233f, Instant.ofEpochMilli(324234)},
                {1287354516.234234d, Instant.ofEpochMilli(1287354516)},
                {BigDecimal.valueOf(1234.5), Instant.ofEpochMilli(1234)},
                {BigInteger.valueOf(3234242), Instant.ofEpochMilli(3234242)},
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testApply(Number given, Instant expected) {
        Assert.assertEquals(new NumberUnixMillisToInstantConverter().apply(given), expected);
    }
}