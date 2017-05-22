package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleiko on 22.05.2017.
 */
public class RegistryOTTSPage extends Page {
    RegistryOTTSPage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle = By.xpath("//*[@id='content']/div//li[2]/span");
    private By getActionBtn = By.xpath(".//div[@class='btn-group']/button/i");
    private By createDocBtn = By.xpath("//li[@wicketpath=\"buttonsPanel_createButtonsContainer\"]/button");
    private By ottsBtn = By.linkText("ОТТС");
    private By typeDocWindow = By.xpath("//h3[text()=\"Вид формируемого документа\"]");
    private By electronicDocType = By.xpath(".//input[@value='2']");
    private By createDocBtn2 = By.xpath(".//input[@value='Создать']");

    @Step("Проверяем открылась ли страница")
    public String isRegistryOTTSPageLoaded(){
        return getElementText(pageTitle);
    }

    @Step("Пользователь открывает страницу создания ОТТС")
    public CreateOTTSPage userGoToCreateOTTSPage(){
        clickOn3Link(getActionBtn,createDocBtn,ottsBtn);
        wait.until(ExpectedConditions.presenceOfElementLocated(typeDocWindow));
        click(electronicDocType);
        click(createDocBtn2);
        return new CreateOTTSPage(driver);
    }



}