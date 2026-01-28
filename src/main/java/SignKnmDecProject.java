import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignKnmDecProject {
    private WebDriver webDriver;

    public SignKnmDecProject(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void clickButtonCimplete() throws InterruptedException {
        new WebDriverWait(webDriver , Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//button[contains(text(),'Подписать')]"))).click();
        Thread.sleep(5000);
        WebElement shadowHost = webDriver.findElement(By.tagName("cdp-filestore-manager[2]"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement fileInput = shadowRoot.findElement(By.cssSelector("button[type='button']"));
        fileInput.click();

    }
}
