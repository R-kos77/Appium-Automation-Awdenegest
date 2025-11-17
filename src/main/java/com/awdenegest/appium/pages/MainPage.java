package com.awdenegest.appium.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    private By firstNameInput = By.id("com.example.amharicnamecalculator:id/firstNameInput");
    private By motherNameInput = By.id("com.example.amharicnamecalculator:id/motherNameInput");
    private By calculateButton = By.id("com.example.amharicnamecalculator:id/calculateButton");
    private By resultText = By.id("com.example.amharicnamecalculator:id/resultText");
    private By detailButton = By.id("com.example.amharicnamecalculator:id/detailButton");
    private By refreshButton = By.id("com.example.amharicnamecalculator:id/refreshButton");

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFirstName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameInput)).sendKeys(name);
    }

    public void enterMotherName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(motherNameInput)).sendKeys(name);
    }

    public void clickCalculate() {
        wait.until(ExpectedConditions.elementToBeClickable(calculateButton)).click();
    }

    public String getResult() {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(resultText));
        return result.getText();
    }

    public boolean isDetailButtonVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(detailButton)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void openDetail() {
        driver.findElement(detailButton).click();
    }

    public void scrollToBottom() {
        driver.findElement(
            AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(3)"
            )
        );
    }

    public void clickRefresh() {
        wait.until(ExpectedConditions.elementToBeClickable(refreshButton)).click();
    }

    public String getFirstNameFieldText() {
        return driver.findElement(firstNameInput).getText().trim();
    }

    public String getMotherNameFieldText() {
        return driver.findElement(motherNameInput).getText().trim();
    }
}
