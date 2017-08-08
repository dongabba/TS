package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.fors.utils.FileWorker;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.FileNotFoundException;

/**
 * Created by Alexander Zhaleiko on 02.07.2017.
 */
public class RegistryEPTSPage extends Page{
    public RegistryEPTSPage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle = By.xpath("//*[@id='content']/div//li[2]/span");
    private By getActionBtn = By.xpath(".//div[@class='btn-group']/button/i");
    private By createEpBtn = By.xpath("//button[@wicketpath=\"buttons_createPassport\"]");
    private By eptsBtn = By.linkText("ЭПТС");
    private By typeDocWindow = By.xpath("//h3[text()=\"Выбор документа\"]");
    private By ottsNumberField = By.cssSelector("div[wicketpath=\"dialog_content_form_content_approvalContainer\"]>div:nth-of-type(2)>div>div>div>div>span>span>span");
    private By ottsDateFromField = By.cssSelector("input[name=\"content:approvalContainer:approval:infoContainer:dateFrom\"]");
    private By goToCreateEptsBtn = By.cssSelector("input[value=\"Перейти к оформлению электронного паспорта\"]");
    private By passportNumberSearchFld = By.cssSelector("input[name=\"passportNumber\"]");
    private By searchBtn = By.cssSelector("button[name=\"search\"]");
    private By mainHeaderLnk = By.linkText("Системы электронных паспортов");
    private By putDataIntoPassportContainerBtn = By.cssSelector("li[wicketpath=\"buttons_putDataIntoPassportContainer\"] button");
    private By recyclingDutyLnk = By.linkText("Сведения об утилизационном сборе");
    private By changeEptsPageHeader = By.xpath("//h1[text()='Изменения в электронном паспорте']");
    //====Изменения в электронном паспорте====
    private By paymentExecutionSelect = By.name("paymentExecution");
    private By applyActionBtn = By.cssSelector("button[wicketpath=\"applyAction\"]");
    private By wicketWindow = By.xpath(".//h3[text()='Информация']");
    private By closeWicketWndBtn = By.cssSelector("input[value=\"Закрыть\"]");
    private By firstRowInSearchTable = By.name("results:body:rows:1:cells:2:cell:check");
    //===Создание регистрационного действия===
    private By createRequestLnk = By.linkText("Подать заявление");
    private By createRequestBtn = By.name("create");
    private By choiseRegisrtyAction = By.xpath("//div[@wicketpath=\"form_listViewContainer\"]/div/div/div[1]/div[2]/div/div//span[@class=\"select2-selection__arrow\"]");
    private By region = By.xpath("//div[@wicketpath=\"form_listViewContainer\"]/div/div/div[1]/div[4]/div/div//span[@class=\"select2-selection__arrow\"]");

    @Step("Пользователь открывает страницу создания ЭП")
    public CreateEPTSPage userOpenCreateEPTSPage(){
        click(getActionBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(createEpBtn));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//button[@wicketpath=\"buttons_createPassport\"]"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(eptsBtn));
        click(eptsBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(typeDocWindow));
        userSelectFromSelectList(ottsNumberField, "ТС RU Е-RU.НТ01.00029");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ottsDateFromField));
        click(goToCreateEptsBtn);
        return new CreateEPTSPage(driver);
    }

    public void userTypeEptsNumbInSearchBtn() throws FileNotFoundException {
        type(passportNumberSearchFld, FileWorker.read("epts.txt"));
    }

    public void userClickMainHeader(){
        click(mainHeaderLnk);
    }

    public void userClickSearchBtn(){
        click(searchBtn);
    }

    public void userClickFirstRowInSearchTable(){
        click(firstRowInSearchTable);
    }

    public void userOpenUtilSborPage(){
        click(getActionBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(putDataIntoPassportContainerBtn));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.cssSelector("li[wicketpath=\"buttons_putDataIntoPassportContainer\"] button"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(recyclingDutyLnk));
        click(recyclingDutyLnk);
        wait.until(ExpectedConditions.visibilityOfElementLocated(changeEptsPageHeader));
    }

    public void userSelectPaymentExecution(){
        Select select = new Select(driver.findElement(By.name("paymentExecution")));
        select.selectByValue("1");
    }

    public void userClickApplyActionBtn(){
        click(applyActionBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(wicketWindow));
    }

    public void userCloseWicketWindow(){
        click(closeWicketWndBtn);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }

    public void waitUntilPageLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }

    public void userOpenCreateRegistryRequestPage() {
        click(getActionBtn);
        wait.until(ExpectedConditions.elementToBeClickable(createRequestLnk));
        click(createRequestLnk);
        wait.until(ExpectedConditions.elementToBeClickable(createRequestLnk));
    }

    public void userCreateRegistryRequest(){
        userSelectFromSelectList(choiseRegisrtyAction, "Постановка на регистрационный учет");
    }

    public void userSelectRegion(){
        userSelectFromSelectList(region, "Москва Город");
    }

    public void userSelectOwnerType(){
        Select select = new Select(driver.findElement(By.cssSelector("select[name*=\"personType\"]")));
        select.selectByValue("1");
    }

    public void userCreateRequest(){
        click(createRequestBtn);
        wait.until(ExpectedConditions.elementToBeClickable(closeWicketWndBtn));
        click(closeWicketWndBtn);
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
    }
}
