package com.yeetrack.selenium.test;

import com.yeetrack.selenium.data.KeywordData;
import com.yeetrack.selenium.spoon.tool.DriverCapture;
import com.yeetrack.selenium.tool.BrowserUtils;
import com.yeetrack.selenium.tool.DriverFactory;
import org.openqa.selenium.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;


/**
* Created by victor on 14-3-19.
*/
public class BrowserTest
{
    Logger logger = LoggerFactory.getLogger(BrowserTest.class);
    private WebDriver driver;
    private String browserType = "firefox";

    @BeforeMethod(alwaysRun = true)
    public void before() throws IOException, AWTException, InterruptedException {
        logger.info("初始化浏览器-->"+browserType);
        driver = DriverFactory.getBrowserDriver(browserType);
        BrowserUtils.fullScreen();
    }

    @Test(dataProvider = "KeywordDataProvider", dataProviderClass = KeywordData.class)
    public void osChinaTest(String keyword) throws Exception {

        logger.info("测试oschina");
        driver.get("http://www.oschina.net/");
        DriverCapture.snapShot("打开oschina", driver);

        driver.findElement(By.id("channel_q")).sendKeys(keyword);
        Thread.sleep(1000);
        DriverCapture.snapShot("输入关键字后", driver);
        //点击搜索按钮
        driver.findElement(By.xpath(".//*[@id='OSC_Banner']/div/form/button")).click();
        Thread.sleep(2000);
        DriverCapture.snapShot("点击搜索按钮，结果", driver);
        driver.quit();
    }

    @Test
    public void qunarTest() throws Exception
    {
        logger.info("doubanTest");
        driver.get("http://www.douban.com");
        DriverCapture.snapShot("打开www.douban.com",driver);

        //在搜索框中搜索
        driver.findElement(By.name("q")).sendKeys("冰与火之歌");
        Thread.sleep(2000);
        DriverCapture.snapShot("输入关键字", driver);

        //输入回车
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        DriverCapture.snapShot("查看搜索结果", driver);

        driver.quit();
    }
}
