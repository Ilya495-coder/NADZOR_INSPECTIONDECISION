import org.example.ApproveKnmDecProjectSpec;
import org.example.Task;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class Basetest {
    DriverFactory factory;
    WebDriver webDriver;
    SearchTask searchTask;
    Autorized autorized;
    Task task;
    ApproveKnmDecProjectSpec approveKnmDecProjectSpec;
    StartINSPECTIONDECISION startInspectionDesigion;
    ApproveKnmDecProjectUn approveKnmDecProjectUn;
    ApproveKnmDecProjectSign approveKnmDecProjectSign;
    Flex_changeKNMInfoToErknmManually flexChangeKNMInfoToErknmManually;
    Flex_enterKnmPassportId flex_enterKnmPassportId;
    SignKnmDecProject signKnmDecProject;


    @BeforeEach
    public void getDriver() {
        factory = new DriverFactory();
        factory.initYandex();
      //  webDriver= factory.initDriver();
        webDriver = factory.getDriver();
        searchTask = new SearchTask(webDriver);
        autorized = new Autorized(webDriver);
        task = new Task(webDriver);
        approveKnmDecProjectSpec = new ApproveKnmDecProjectSpec(webDriver);
        startInspectionDesigion = new StartINSPECTIONDECISION(webDriver);
        approveKnmDecProjectUn = new ApproveKnmDecProjectUn(webDriver);
        approveKnmDecProjectSign = new ApproveKnmDecProjectSign(webDriver);
        flexChangeKNMInfoToErknmManually = new Flex_changeKNMInfoToErknmManually(webDriver);
        flex_enterKnmPassportId = new Flex_enterKnmPassportId(webDriver);
        signKnmDecProject = new SignKnmDecProject(webDriver);
        webDriver.get("https://smart-dev.reinform-int.ru/main/");
    }
    @AfterEach
    public void quit(){
        webDriver.quit();
    }
}
