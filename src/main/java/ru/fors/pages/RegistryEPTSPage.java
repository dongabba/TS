package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

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

    @Step("Пользователь открывает страницу создания ЭП")
    public CreateEPTSPage userOpenCreateEPTSPage(){
        click(getActionBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(createEpBtn));
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//button[@wicketpath=\"buttons_createPassport\"]"))).perform();
        wait.until(ExpectedConditions.elementToBeClickable(eptsBtn));
        click(eptsBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(typeDocWindow));
        userSelectFromSelectList(ottsNumberField, "ТС RU E-RU.МТ01.00005");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ottsDateFromField));
        click(goToCreateEptsBtn);
        return new CreateEPTSPage(driver);
    }
}
