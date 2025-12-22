import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
        // Указываем, где лежит Yandex Browser
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "D:\\drivers\\yandex\\driver\\yandexdriver.exe");
        // options.addExtensions()
        options.setBinary("C:\\Program Files\\Yandex\\YandexBrowser\\Application\\browser.exe");
        // Используем ваш профиль, где уже всё настроено
        options.addArguments("--user-data-dir=C:\\Users\\Илюха\\AppData\\Local\\Yandex\\YandexBrowser\\User Data");
        options.addArguments("--profile-directory=Profile 1");
        // Запуск
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://smartid.reinform.ru/iam/auth/realms/smart/protocol/openid-connect/auth?client_id=smart-app&redirect_uri=https%3A%2F%2Fsmart-dev.reinform-int.ru%2Foauth%2Fcallback&response_type=code&scope=openid+email+profile&state=e1fea4b5-fc08-4999-8a02-865b935a4c0d"); // ← сюда подставьте нужный сайт

        // Теперь нажмите кнопку "Подписать" — подпись должна появиться сама
        // (если сайт помещает её в поле, вы сможете её прочитать)
    }
}
