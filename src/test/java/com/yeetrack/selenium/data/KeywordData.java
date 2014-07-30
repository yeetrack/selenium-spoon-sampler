package com.yeetrack.selenium.data;

import org.testng.annotations.DataProvider;

/**
 * Created by xuemeng.wang on 2014/7/29.
 */
public class KeywordData
{
    @DataProvider(name="KeywordDataProvider")
    public static Object[][] keywordProvider()
    {
        return new Object[][] {{"apache"}, {"tomcat"}};
    }
}
