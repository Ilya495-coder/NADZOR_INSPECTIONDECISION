import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BPrinrifinspdec_issueKnmDecisTest extends Basetest {

    @DisplayName("Проверка стартовой формы.Выбор Привлечение экспертиз. Проверка отображения полей на форме.")
    @Test
    public void StartINSPECTIONDECISIONShowExpertizeOrganization() throws Exception {
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
        WebElement visibleRequisites = new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//label[contains(text(),'Реквизиты основания')]")));
        try {
            visibleRequisites.isDisplayed();
        } catch (Exception e) {
            throw new NoSuchElementException("Поле \"Реквизиты основания\" не обнаружено на форме");
        }
        startInspectionDesigion.selectKnmType();
        startInspectionDesigion.selectSupervisor("Гончаров Илья Владимирович");
        startInspectionDesigion.enableExpertiseAndSpecialist();
        WebElement selectOrganization = new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//label[contains(text(),'Привлечь организацию')]")));

        try {
            selectOrganization.isDisplayed();
        } catch (Exception e) {
            throw new NoSuchElementException("Поле 'Привлечь организацию' не обнаружено на форме");
        }
        try {
            selectOrganization.isSelected();
        } catch (Exception e) {
            throw new NoSuchElementException("В поле 'Привлечь организацию' не проставлен чек бокс");
        }

        WebElement fieldExpertizeOrganization = new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//label[contains(text(),'Экспертная организация')]")));
        try {
            fieldExpertizeOrganization.isDisplayed();
        } catch (Exception e) {
            throw new NoSuchElementException("Поле 'Экспертная организация' не обнаружено на форме");
        }
        //Текст в поле Экспертная организация
        By inputExpertizeOrganization = By.xpath("(.//ng-select[contains(@class,'ng-select') and contains(@class,'ng-select-single') and contains(@class,'ng-select-searchable') and contains(@class,'ng-select-clearable') and contains(@class,'ng-untouched') and contains(@class,'ng-pristine') and contains(@class,'ng-valid')])[1]/div/div/div[2]/span[2]");
        WebElement webElement = webDriver.findElement(inputExpertizeOrganization);
        String textFieldExpertize = webElement.getText();
        try {
            assertEquals("ГБУ \"ЦЭИИС\"", textFieldExpertize);
        } catch (Exception e) {
            throw new NoSuchElementException("Поле 'Экспертная организация' не предзаполнилось щначением (ГБУ 'ЦЭИИС')");
        }
        WebElement fieldProb = new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//label[contains(text(),'Подготовить протокол отбора проб (образцов)')]")));
        try {
            fieldProb.isDisplayed();
        } catch (Exception e) {
            throw new NoSuchElementException("Поле 'Подготовить протокол отбора проб (образцов)' не обнаружено на форме");
        }
        WebElement fieldGiveExpert = new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//label[contains(text(),'Привлечь эксперта')]")));
        try {
            fieldGiveExpert.isDisplayed();
        } catch (Exception e) {
            throw new NoSuchElementException("Поле 'Привлечь эксперта' не обнаружено на форме");
        }
        startInspectionDesigion.setKnmDatesAndTimes("22122025", "25122025");
        startInspectionDesigion.setKnmDuration("1", "1530");
        startInspectionDesigion.selectApprover("Гончаров Илья Владимирович");
        startInspectionDesigion.selectConfirmer("Гончаров Илья Владимирович");
        startInspectionDesigion.submitForApproval();
        //проверка завершения задачи
        autorized.resoultText();
        autorized.clickExit();
    }

    @DisplayName("Проверка стартовой формы.Подписание мотивированного представления.")
    @Test
    public void StartINSPECTIONDECISION() throws Exception {
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
        //startInspectionDesigion.selectKnmBasis();
        WebElement selectBase = webDriver.findElement(By.xpath(".//label[contains(text(),'Основание для КНМ')]/following-sibling::div/ng-select/div/div/div[3]/input"));
        selectBase.sendKeys("истечение срока исполнения предписания, выданного в рамках");
        WebElement inputElement = new WebDriverWait(webDriver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//span[contains(text(),'истечение срока исполнения предписания, выданного в рамках проведения программы проверок')]")));
        inputElement.click();
        startInspectionDesigion.clickAddObject();
        startInspectionDesigion.searchAndSelectObject("232323");
        startInspectionDesigion.selectControlledEntity();
        startInspectionDesigion.selectKnmType();
        startInspectionDesigion.selectSupervisor("Гончаров Илья Владимирович");
        startInspectionDesigion.enableExpertiseAndSpecialist();
        startInspectionDesigion.setKnmDatesAndTimes("22122025", "25122025");
        startInspectionDesigion.setKnmDuration("1", "1530");
        WebElement textVisible = webDriver.findElement(By.xpath(".//label[contains(text(),'Указанные сведения')]/following-sibling::div/span"));
        String actual = textVisible.getText();
        assertEquals("Являются основанием для проведения надзорного мероприятия", actual);
        startInspectionDesigion.selectApprover("Гончаров Илья Владимирович");
        startInspectionDesigion.selectConfirmer("Гончаров Илья Владимирович");
        WebElement fieldMotiv = webDriver.findElement(By.xpath(".//span[contains(text(),'Мотивированное представление')]"));
        try {
            fieldMotiv.isDisplayed();
        } catch (Exception e) {
            throw new NoSuchElementException("Поле \"Мотивированное представление\" не обнаружено на форме");
        }
        webDriver.findElement(By.xpath(".//button[contains(text(),'Подписать')]")).click();
        startInspectionDesigion.signed();
        WebElement visibleText = new WebDriverWait(webDriver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[contains(text(),'Мотивированное представление было сформировано и подписано.')]")));
       assertTrue( visibleText.isDisplayed());
        startInspectionDesigion.submitForApproval();
        //проверка завершения задачи
        autorized.resoultText();
        autorized.clickExit();
    }

    @DisplayName("Прохождение БП Выпуск Решения проведения КНМ")
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

        //Спец управление третья задача
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

        //Спец управление четвертая задача
        autorized.autorize("ilya", "Ghbdtn123");
        //заходим в витрину задач
        searchTask.clickGosuslugi();
        searchTask.getTasks();
        task.getElementTask();
        //завершаем задачу
        approveKnmDecProjectSpec.clickButtonPrimary();
        //проверка завершения задачи
        autorized.resoultText();
        searchTask.getTasks();
        task.getElementTask();
        //завершаем задачу
        approveKnmDecProjectUn.clickButonApprove();
        //проверка завершения задачи
        autorized.resoultText();
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

        //Утвердить решение
        //открываем задачу
        task.getElementTask();
        signKnmDecProject.clickButtonCimplete();
        //проверка завершения задачи
        autorized.resoultText();
    }


}