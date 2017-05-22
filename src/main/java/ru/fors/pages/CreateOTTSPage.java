package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleiko on 22.05.2017.
 */
public class CreateOTTSPage extends Page{
    CreateOTTSPage(WebDriver driver) {
        super(driver);
    }

    private By docNumberFld = By.xpath("//input[@name=\"commonProperties:numberVersionContainer:number\"]");

    @Step("Проверяем открылась ли страница создания ОТТС")
    public boolean isCreteOTTSPageOpen(){
        return ensurePageLoaded(docNumberFld);
    }

}
