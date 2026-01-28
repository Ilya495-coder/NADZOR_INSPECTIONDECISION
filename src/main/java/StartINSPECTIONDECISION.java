import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartINSPECTIONDECISION {
    private WebDriver webDriver;

    public StartINSPECTIONDECISION(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Вид надзора
    By supervisionTypeInput = By.xpath("//*[@id='skeleton_content']/div/cdp-view/app-root/app-decision-create/div/div/div[2]/form/enter-information-form/div[1]/div/ng-select/div/div/div[3]/input");
    By supervisionTypeOption = By.xpath("//span[contains(@class, 'ng-option-label') and normalize-space()='региональный государственный строительный надзор']");

    // Основание для КНМ
    By knmBasisInput = By.xpath(".//label[contains(text(),'Основание для КНМ')]/following-sibling::div/ng-select/div/div/div[3]/input");
    By knmBasisOption = By.xpath(".//span[contains(@class,'ng-option-label') and contains(@class, 'ng-star-inserted') and text()='программа проверок']");

    // Кнопка "Добавить объект"
    By addObjectButton = By.xpath(".//button[@class='btn btn-primary ng-star-inserted']");

    // Модальное окно выбора объекта
    By objectSearchInput = By.xpath("/html/body/modal-container/div/div/select-object-component/div[2]/form/div[1]/div/input");
    By selectObjectCheckbox = By.xpath("/html/body/modal-container/div/div/select-object-component/div[2]/form/div[2]/div/table/tbody/tr/td[1]/input");
    By confirmObjectSelection = By.xpath("/html/body/modal-container/div/div/select-object-component/div[2]/form/div[3]/div/button[1]");

    // Контролируемое лицо
    By controlledEntityInput = By.xpath("//*[@id='skeleton_content']/div/cdp-view/app-root/app-decision-create/div/div/div[2]/form/enter-information-form/div[4]/div/ng-select/div/div/div[3]/input");
    By controlledEntityOption = By.xpath("//span[@class='ng-star-inserted' and text()='Центр содействия жилищной реформе (Генеральный подрядчик)']");

    // Тип КНМ
    By knmTypeInput = By.xpath("//*[@id='skeleton_content']/div/cdp-view/app-root/app-decision-create/div/div/div[2]/form/enter-information-form/div[8]/div/ng-select/div/div/div[3]/input");
    By knmTypeOption = By.xpath(".//span[@class='ng-option-label ng-star-inserted' and text()='Выездная']");

    // Ответственный за осуществление надзора
    By supervisorInput = By.xpath("//h3[normalize-space()='Уполномоченные на проведение КНМ']" +
            "//following::label[contains(., 'Ответственный за осуществление надзора')]" +
            "//following-sibling::div//input[@aria-autocomplete='list']");
    By supervisorOption = By.xpath("//h3[normalize-space()='Уполномоченные на проведение КНМ']" +
            "//following::label[contains(., 'Ответственный за осуществление надзора')]" +
            "//following-sibling::div//ng-dropdown-panel//span[normalize-space()='Гончаров Илья Владимирович']");

    // Привлечение экспертизы
    By expertiseYes = By.name("yesExpertise");
    By specialistEngage = By.name("isEngageSpecialist");

    // ФИО специалиста МГСН
    By specialistInput = By.xpath("//div[contains(@class, 'form-group')][.//label[contains(., 'ФИО специалиста')]]//input[@aria-autocomplete='list']");
    By specialistOption = By.xpath(".//span[@class='ng-option-label ng-star-inserted' and text()='Гончаров Илья Владимирович']");

    // Дата и время начала КНМ
    By startDateInput = By.xpath("//label[contains(.,'Дата начала КНМ')]/following-sibling::div//input[@placeholder='__.__.____' and @class='form-control']");
    By startTimeInput = By.xpath(".//label[contains(text(),'Время начала КНМ')]/following-sibling::input");

    // Дата и время окончания КНМ
    By endDateInput = By.xpath("//label[contains(.,'Дата окончания КНМ')]/following-sibling::div//input[@placeholder='__.__.____' and @class='form-control']");
    By endTimeInput = By.xpath(".//label[contains(text(),'Время окончания КНМ')]/following-sibling::input");

    // Срок проведения КНМ (раб. дней)
    By deadlineInput = By.xpath(".//input[@placeholder='ДН']");

    // Срок непосредственного взаимодействия
    By interactionTimeInput = By.xpath(".//input[@class='form-control ng-untouched ng-pristine ng-valid' and @placeholder='00:00']");

    // Согласовывает
    By approvesInput = By.xpath("//label[contains(., 'Согласовывает')]/following-sibling::div//input[@aria-autocomplete='list']");
    By approvesOption = By.xpath(".//span[@class='ng-option-label ng-star-inserted' and text()='Гончаров Илья Владимирович']");

    // Утверждает
    By confirmsInput = By.xpath("//label[contains(., 'Утверждает')]/following-sibling::div//input[@aria-autocomplete='list']");
    By confirmsOption = By.xpath(".//span[@class='ng-option-label ng-star-inserted' and text()='Гончаров Илья Владимирович']");

    // Кнопка завершения
    By submitForApprovalButton = By.xpath(".//button[@class='btn btn-primary m-r-sm' and contains(text(),'На согласование')]");

    public void selectSupervisionType() {
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(supervisionTypeInput)).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(supervisionTypeOption)).click();
    }

    public void clickKnmBasisInput() {
        webDriver.findElement(knmBasisInput).click();
    }

    public void selectKnmBasis() {
        WebElement basisInput = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(knmBasisInput));
        basisInput.click();
        basisInput.sendKeys("программа проверок");
        webDriver.findElement(knmBasisOption).click();
    }

    public void clickAddObject() {
        webDriver.findElement(addObjectButton).click();
    }

    public void searchAndSelectObject(String objectCode) {
        WebElement searchInput = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(objectSearchInput));
        searchInput.click();
        searchInput.sendKeys(objectCode);

        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectObjectCheckbox)).click();
        webDriver.findElement(confirmObjectSelection).click();
    }

    public void selectControlledEntity() {
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(controlledEntityInput)).click();
        webDriver.findElement(controlledEntityOption).click();
    }

    public void selectKnmType() {
        webDriver.findElement(knmTypeInput).click();
        WebElement knmTypeElement = webDriver.findElement(knmTypeOption);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", knmTypeElement);
        knmTypeElement.click();
    }

    public void selectSupervisor(String supervisorName) {
        WebElement input = new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(supervisorInput));
        input.click();
        input.sendKeys(supervisorName);

        WebElement option = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(supervisorOption));
        option.click();
    }

    public void enableExpertiseAndSpecialist() {
        webDriver.findElement(expertiseYes).click();
        // webDriver.findElement(specialistEngage).click();
    }

    public void selectSpecialist(String specialistName) {
        WebElement input = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(specialistInput));
        input.click();
        input.sendKeys(specialistName);
        webDriver.findElement(specialistOption).click();
    }

    public void setKnmDatesAndTimes(String startDate, String endDate) {
        WebElement startDateEl = webDriver.findElement(startDateInput);
        startDateEl.click();
        startDateEl.sendKeys(startDate);

        WebElement startTimeEl = webDriver.findElement(startTimeInput);
        startTimeEl.click();
        startTimeEl.sendKeys("1515");

        WebElement endDateEl = webDriver.findElement(endDateInput);
        endDateEl.click();
        endDateEl.sendKeys(endDate);

        WebElement endTimeEl = webDriver.findElement(endTimeInput);
        endTimeEl.click();
        endTimeEl.sendKeys("1615");
    }

    public void setKnmDuration(String workDays, String interactionTime) {
        WebElement deadlineEl = webDriver.findElement(deadlineInput);
        deadlineEl.click();
        deadlineEl.sendKeys(workDays);

        WebElement controlEl = webDriver.findElement(interactionTimeInput);
        controlEl.click();
        controlEl.sendKeys(interactionTime);
    }

    public void selectApprover(String approverName) {
        WebElement input = webDriver.findElement(approvesInput);
        input.click();
        input.sendKeys(approverName);
        webDriver.findElement(approvesOption).click();
    }

    public void selectConfirmer(String confirmerName) {
        WebElement input = webDriver.findElement(confirmsInput);
        input.click();
        input.sendKeys(confirmerName);
        webDriver.findElement(confirmsOption).click();
    }

    public void submitForApproval() {
        webDriver.findElement(submitForApprovalButton).click();
    }

    public void signed() throws InterruptedException {

        Thread.sleep(5000);
        WebElement shadowHost = webDriver.findElement(By.xpath("(//cdp-filestore-manager)[2]"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        WebElement fileInput = shadowRoot.findElement(By.cssSelector("button[type='button']"));
        fileInput.click();

    }
}
