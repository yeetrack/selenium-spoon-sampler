package com.yeetrack.selenium.data;

import org.testng.annotations.DataProvider;

/**
 * Created by xuemeng.wang on 2014/7/29.
 */
public class BrowserData
{
    @DataProvider(name = "BrowserTypeDataProvider")
    public static Object[][] browserTypeProvider()
    {
        return new Object[][] { {"firefox"}, {"chrome"}};
    }
}
