import org.example.ApproveKnmDecProjectSpec;
import org.example.Task;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.WebDriver;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SmartDevTest extends Basetest{

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
//        autorized.clickExit();
//
//        //Согласовать зам председателя
//        //авторизация
//        autorized.autorize("ilya", "Ghbdtn123");
//        // заходим в витрину задач
//        searchTask.clickGosuslugi();
        searchTask.getTasks();
        task.getElementTask();
        //завершаем задачу
        approveKnmDecProjectSign.clickButonApprove();
        //проверка завершения задачи
        autorized.resoultText();
        autorized.clickExit();

        Thread.sleep(2000);
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
        autorized.clickExit();

        Thread.sleep(2000);
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
//        autorized.clickExit();
//
//
//        //Утвердить решение
//        //авторизация
//        autorized.autorize("ilya", "Ghbdtn123");
//        //заходим в витрину задач
//        searchTask.clickGosuslugi();
//        searchTask.getTasks();
        //открываем задачу
        task.getElementTask();
        signKnmDecProject.clickButtonCimplete();
        //проверка завершения задачи
        autorized.resoultText();
    }


}