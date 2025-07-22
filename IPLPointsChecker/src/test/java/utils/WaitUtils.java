package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.function.Function;

public class WaitUtils {

    public static WebDriver driver;

    public WaitUtils(WebDriver driver) {
        WaitUtils.driver = driver;
    }

    // 1. EXPLICIT WAIT
    public WebElement waitForVisibility(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForTextToBePresent(By locator, String text, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    // 2. FLUENT WAIT
    public WebElement fluentWait(By locator, int timeoutSeconds, int pollingMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(timeoutSeconds))
            .pollingEvery(Duration.ofMillis(pollingMillis))
            .ignoring(NoSuchElementException.class);

        return wait.until(driver -> driver.findElement(locator));
    }

    // 3. JS WAIT – Wait for document ready
    public void waitForPageLoad(int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete")
        );
    }

    // 4. JS WAIT – Wait for jQuery/Ajax to finish
    public void waitForjQueryLoad(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            return (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active === 0;");
        });
    }

    // 5. JS Highlight Element (Optional for Debugging)
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}
