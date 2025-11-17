package com.awdenegest.appium.tests;

import com.awdenegest.appium.pages.MainPage;
import com.awdenegest.appium.utils.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AwdeNegestTest {

    private AndroidDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
        mainPage = new MainPage(driver);
    }

    // MULTIPLE NAME PAIRS
    @DataProvider(name = "amharicNames")
    public Object[][] createTestData() {
        return new Object[][]{
            {"አልበታ", "ማርያም"},
            {"ሚካኤል", "ሀና"},
            {"ዳዊት", "ሳራ"}
        };
    }

    @Test(dataProvider = "amharicNames")
    public void testAmharicNameCalculation(String firstName, String motherName) {

        mainPage.enterFirstName(firstName);
        mainPage.enterMotherName(motherName);

        mainPage.clickCalculate();

        String result = mainPage.getResult();
        System.out.println("Result: " + result);

        Assert.assertTrue(result.contains("ኮከብ"), "Result should contain 'ኮከብ'");

        if (mainPage.isDetailButtonVisible()) {
            mainPage.openDetail();
            mainPage.scrollToBottom();
            driver.navigate().back();
        }

        mainPage.clickRefresh();

        String fText = mainPage.getFirstNameFieldText();
        String mText = mainPage.getMotherNameFieldText();

        // Handling hints
        Assert.assertTrue(
            fText.isEmpty() || fText.equals("ስም"),
            "First name input should be empty or hint"
        );

        Assert.assertTrue(
            mText.isEmpty() || mText.equals("የእናት ስም"),
            "Mother name input should be empty or hint"
        );
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
