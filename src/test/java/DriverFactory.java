

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.configuration2.builder.ConfigurationBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.lang.module.Configuration;
import java.nio.file.Path;
import java.nio.file.Paths;

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

    private void initYandex() {
       /// WebDriverManager.chromedriver().driverVersion(System.getProperty("version")).setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IGoncharov\\Desktop\\тестовый\\yandexdriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/chrome/opera_cryptopro_extension_v3_latest.crx"));
        options.setBinary(System.getProperty("bin"));

        driver = new ChromeDriver(options);
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}
