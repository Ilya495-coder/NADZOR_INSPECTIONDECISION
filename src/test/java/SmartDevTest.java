import org.example.ApproveKnmDecProjectSpec;
import org.example.Task;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmartDevTest {
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
        webDriver = new ChromeDriver();
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


    @Test
    public void printStartINSPECTIONDECISION() throws InterruptedException {
        //Стартовая форма
        //авторизация
        autorized.autorize("ilya", "Ghbdtn123");
        // заходим в возможности и ищем задачу
        searchTask.clickGosuslugi();
        searchTask.clickVozmoznosti();
        searchTask.setTask("Создать проект Решения о проведении КНМ");
        searchTask.getClickFind();
        searchTask.getClickTask();
        //заполняем стартовую форму
        startInspectionDesigion.selectSupervisionType();
        startInspectionDesigion.selectKnmBasis();
        startInspectionDesigion.clickAddObject();
        startInspectionDesigion.searchAndSelectObject("232323");
        startInspectionDesigion.selectControlledEntity();
        startInspectionDesigion.selectKnmType();
        startInspectionDesigion.selectSupervisor("Гончаров Илья Владимирович");
        startInspectionDesigion.enableExpertiseAndSpecialist();
        // startInspectionDesigion.selectSpecialist("Гончаров Илья Владимирович");
        startInspectionDesigion.setKnmDatesAndTimes("22122025", "25122025");
        startInspectionDesigion.setKnmDuration("1", "1530");
        startInspectionDesigion.selectApprover("Гончаров Илья Владимирович");
        startInspectionDesigion.selectConfirmer("Гончаров Илья Владимирович");
        startInspectionDesigion.submitForApproval();
        //проверка завершения задачи
        autorized.resoultText();
        autorized.clickExit();

        //Спец управление первая задача
        autorized.autorize("martiushev_da", "VsKexibt21");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        // завершаем задачу
        task.getElementTask();
        approveKnmDecProjectSpec.clickButtonPrimary();
        //    проверка завершения задачи
        autorized.resoultText();
        // webDriver.quit();
        autorized.clickExit();

        //Спец управление вторая задача
        autorized.autorize("ilya", "Ghbdtn123");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        task.getElementTask();
        //завершаем задачу
        approveKnmDecProjectSpec.clickButtonPrimary();
        //проверка завершения задачи
        autorized.resoultText();
        //  webDriver.quit();
        autorized.clickExit();

        //Спец управление третья задача
        //авторизация
        autorized.autorize("tupitsyna_ks", "Ktupitsyna123");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        task.getElementTask();
        // завершаем задачу
        approveKnmDecProjectSpec.clickButtonPrimary();
        //проверка завершения задачи
        autorized.resoultText();
        //  webDriver.quit();
        autorized.clickExit();

        //Спец управление четвертая задача
        //авторизация
        autorized.autorize("ivanov_ii", "VsKexibt21");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        task.getElementTask();
        //завершаем задачу
        approveKnmDecProjectSpec.clickButtonPrimary();
        //проверка завершения задачи
        autorized.resoultText();
        // webDriver.quit();
        autorized.clickExit();

        //Согласовать нач управления
        //авторизация
        autorized.autorize("ilya", "Ghbdtn123");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        task.getElementTask();
        //завершаем задачу
        approveKnmDecProjectUn.clickButonApprove();
        //проверка завершения задачи
        autorized.resoultText();
        //  webDriver.quit();
        autorized.clickExit();

        //Согласовать зам председателя
        //авторизация
        autorized.autorize("ilya", "Ghbdtn123");
        // заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        task.getElementTask();
        //завершаем задачу
        approveKnmDecProjectSign.clickButonApprove();
        //проверка завершения задачи
        autorized.resoultText();
        //    webDriver.quit();
        autorized.clickExit();

        Thread.sleep(3);
        //Разместить сведения о КНМ В ЕРКНМ вручную
        //авторизация
        autorized.autorize("ilya", "Ghbdtn123");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        //выбираем задачу
        task.getElementTask();
        flexChangeKNMInfoToErknmManually.setErknmNum();
        flexChangeKNMInfoToErknmManually.clickQRDropzone();
        flexChangeKNMInfoToErknmManually.clickButtonComplete();
        //проверка завершения задачи
        autorized.resoultText();
        // webDriver.quit();
        autorized.clickExit();

        Thread.sleep(3);
        //Разместить идентификатор ЕРКНМ
        //авторизация
        autorized.autorize("ilya", "Ghbdtn123");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        //завершаем задачу
        task.getElementTask();
        flex_enterKnmPassportId.clickButtonGetTask();
        flex_enterKnmPassportId.setErknmGuid();
        flex_enterKnmPassportId.clickButtonComplete();
        //проверка завершения задачи
        autorized.resoultText();
        // webDriver.quit();
        autorized.clickExit();


        //Утвердить решение
        //авторизация
        autorized.autorize("ilya", "Ghbdtn123");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        //открываем задачу
        task.getElementTask();
        signKnmDecProject.clickButtonCimplete();
        //проверка завершения задачи
        autorized.resoultText();
    }

}