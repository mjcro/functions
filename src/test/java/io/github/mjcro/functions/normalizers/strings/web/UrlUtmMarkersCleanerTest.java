package io.github.mjcro.functions.normalizers.strings.web;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UrlUtmMarkersCleanerTest {
    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{
                {null, null},
                {" ", ""},
                {
                        "https://google.com/",
                        "https://google.com/"
                },
                {
                        "https://www.domain.tld/shop?utm_source=newsletter&utm_medium=email&utm_campaign=spring_sale",
                        "https://www.domain.tld/shop"
                },
                {
                        "https://www.domain.tld/shop?utm_source=newsletter&utm_medium=email&utm_campaign=spring_sale#top",
                        "https://www.domain.tld/shop#top"
                },
                {
                        "https://www.domain.tld/shop?utm_source=newsletter&id=81&utm_medium=email&utm_campaign=spring_sale#top",
                        "https://www.domain.tld/shop?id=81#top"
                }
        };
    }

    @Test(dataProvider = "dataProvider")
    public void testApply(String given, String expected) {
        Assert.assertEquals(new UrlUtmMarkersCleaner().apply(given), expected);
    }
}