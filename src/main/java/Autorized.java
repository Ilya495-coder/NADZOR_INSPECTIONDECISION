import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Autorized {
    private WebDriver webDriver;

    public Autorized(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    //авторизация
    By clickAutorized = By.xpath(".//a[contains(@class,'login-page__login title_login')]");
    By userNameField = By.id("username");
    By passwordField = By.id("password");
    By clickEnter = By.id("kc-login");
    By exit = By.cssSelector(".fa-sign-out");
    By resoult = By.xpath("//span[@class='m-r-xs' and normalize-space()='Все задачи']");

    public void getClickLogin() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(clickAutorized)).click();
    }

    public void clearName() {
        webDriver.findElement(userNameField).clear();
    }

    public void setUserName(String login) {
        webDriver.findElement(userNameField).sendKeys(login);
    }

    public void clearPassword() {
        webDriver.findElement(passwordField).clear();
    }

    public void setPassword(String password) {
        webDriver.findElement(passwordField).sendKeys(password);
    }

    public void clickAutorize() {
        new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(clickEnter)).click();
    }

    public void clickExit() {
        new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(exit)).click();
    }

    //проверка завершения задачи
    public String resoultText() {
        try {
            return new WebDriverWait(webDriver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(resoult)).getText();
        } catch (Exception e) {
            throw new RuntimeException("Задача не завершена: витрина задач не открыта.");
        }
    }

    public void autorize(String login, String password) {
        getClickLogin();
        clearName();
        setUserName(login);
        clearPassword();
        setPassword(password);
        clickAutorize();
    }
}
