import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class SignKnmDecProject {
    private WebDriver webDriver;

    public SignKnmDecProject(WebDriver webDriver) {
        this.webDriver = webDriver;

    }
    By buttonComplete=By.xpath(".//button[normalize-space()='Подписать']");

    public void clickButtonCimplete(){
        WebElement webElement =  new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(buttonComplete));
        System.out.println(webElement.isDisplayed());
        webElement.click();
//        Robot robot = new Robot();
//        Thread.sleep(1000); // ждём появления окна
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
