import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
//import org.openqa.selenium.devtools.v133.fetch.Fetch;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.SearchContext;


import java.net.URL;
import java.nio.file.Paths;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Flex_changeKNMInfoToErknmManually {
    private WebDriver webDriver;

    public Flex_changeKNMInfoToErknmManually(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    By erknmNum = By.name("data[ErknmDoc.erknmInfo.erknmNum]");
    By buttonComplete = By.xpath("//div[normalize-space()='Сведения внесены']");

    public void setErknmNum() {
        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(erknmNum)).sendKeys("123456789");
    }



    public void clickQRDropzone() {
        String filePath = getTestFilePath("test-files/qr.jpg");

        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[contains(@class, 'formio-component-ErknmDoc.qr.fileQRCode')]")));

        WebElement shadowHost = webDriver.findElement(By.tagName("cdp-filestore-manager"));
        SearchContext shadowRoot = shadowHost.getShadowRoot(); // ← SearchContext

        WebElement fileInput = shadowRoot.findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(filePath);

        ((JavascriptExecutor) webDriver).executeScript(
                "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
                fileInput
        );
    }


    public void clickButtonComplete() throws InterruptedException {
       Thread.sleep(5000);
    new WebDriverWait(webDriver, Duration.ofSeconds(15))
            .until(ExpectedConditions.elementToBeClickable(buttonComplete)).click();
}




    public String getTestFilePath(String fileName) {
        URL resource = getClass().getClassLoader().getResource(fileName);
        if (resource == null) {
            throw new RuntimeException("Файл не найден в ресурсах: " + fileName);
        }
        try {
            return Paths.get(resource.toURI()).toFile().getAbsolutePath();
        }
        catch (Exception e) {
            throw new RuntimeException("Не удалось получить путь к файлу: " + fileName, e);
        }
    }

}