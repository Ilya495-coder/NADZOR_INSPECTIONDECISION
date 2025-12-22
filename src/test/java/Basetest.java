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
        factory.initDriver();
       // webDriver= factory.initDriver();
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
        webDriver.get("https://smartid.reinform.ru/iam/auth/realms/smart/protocol/openid-connect/auth?client_id=smart-app&redirect_uri=https%3A%2F%2Fsmart-dev.reinform-int.ru%2Foauth%2Fcallback&response_type=code&scope=openid+email+profile&state=554ddeb1-766c-48ce-b076-f3b37cdb7e2b");

    }
    @AfterEach
    public void quit(){
        webDriver.quit();
    }
}
