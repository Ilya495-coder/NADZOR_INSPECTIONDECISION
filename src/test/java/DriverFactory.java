

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class DriverFactory {
    private RemoteWebDriver driver;

    public void initDriver() {
        // System.out.println("browser = " + System.getProperty("browser"));
        if ("firefox".equals(System.getProperty("browser"))) {
            setupFirefox();
        } else if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        } else {
            setupChrome();
        }
    }

    public void setupChrome() {
        //   WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void setupFirefox() {
        WebDriverManager.firefoxdriver().setup();
        var opts = new FirefoxOptions().configureFromEnv();
        driver = new FirefoxDriver(opts);
    }

//public RemoteWebDriver initDriver() {
//    System.setProperty("webdriver.chrome.driver", "D:\\drivers\\yandex\\driver\\yandexdriver.exe");
//    var options = new ChromeOptions();
//    options.setBinary("D:\\drivers\\yandex\\browser\\Application\\browser.exe");
//    String userDataDir = "D:\\drivers\\yandex\\profile\\User Data";
//    options.addArguments("user-data-dir=" + userDataDir);
//    options.addArguments("--profile-directory=Profile 1");
//    options.addArguments("--no-sandbox");
//    options.addArguments("--disable-dev-shm-usage");
//    options.addArguments("--disable-gpu");
//    driver = new ChromeDriver(options);
//    return driver;
//}
private void initYandex() {
        WebDriverManager.chromedriver().driverVersion(System.getProperty("version")).setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary(System.getProperty("bin"));
        String userDataDir = "C:\\Users\\Илюха\\AppData\\Local\\Yandex\\YandexBrowser\\User Data";
        options.addArguments("user-data-dir=" + userDataDir);
        options.addArguments("--profile-directory=Profile 1");
    //   options.addExtensions(new File("src/main/resources/chrome/cryptoPRO.crx"));
        driver = new ChromeDriver(options);
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}
