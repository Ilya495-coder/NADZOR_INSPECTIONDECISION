import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;


public class DriverFactory {
    private RemoteWebDriver driver;
    public void initYandex() {
       /// WebDriverManager.chromedriver().driverVersion(System.getProperty("version")).setup();
        ChromeOptions options = new ChromeOptions();
      //  String driverPath = "C:\\Users\\IGoncharov\\AppData\\Local\\Programs\\Opera\\opera.exe";
       // File driverFile = new File(driverPath);
        options.setBinary("C:\\Users\\IGoncharov\\AppData\\Local\\Programs\\Opera\\opera.exe");
        options.addExtensions(new File("src/main/resources/opera_cryptopro_extension_v3_latest.crx"));
        // System.setProperty("webdriver.chrome.driver", driverFile.getAbsolutePath());
          System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver(options);
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}
