package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class MainPage extends Page {

	MainPage(WebDriver driver) {
		super(driver);
	}
	private By userOrganisation = By.xpath("//*[@id='main']//span[2]");
	private By userInfoDropDown = By.xpath("//*[@id='main']//i[2]");
	private By logoutLink = By.linkText("Выход");
	private By registryOTTS = By.linkText("Реестр ОТТС");
	private By registryLink = By.cssSelector(".icon-menu.registry");
	private By registryEPTS = By.linkText("Реестр электронных паспортов");
	private By requestLink = By.cssSelector(".icon-menu.request");
	private By registryRequestLnk = By.linkText("Заявление о внесении сведений о регистрационных действиях");


    @Step("Проверяем открылась ли страница")
	public boolean isMainPageLoaded(){
        return ensurePageLoaded(userOrganisation);
    }


	@Step("Проверяем роль пользователя")
	public String getUserOrganisation(){
		return getElementText(userOrganisation);
	}
	
	@Step("Пользователь выходит из системы")
	public LoginPage userLogOut(){
		click(userInfoDropDown);
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		click(logoutLink);
		return new LoginPage(driver);
	}

	@Step("Пользователь переходит в реестр ОТТС")
	public RegistryOTTSPage userGoToRegistryOTTSPage(){
		click(registryOTTS);
		return new RegistryOTTSPage(driver);

	}

	@Step("Пользователь переходит в реестр ОТТС")
	public RegistryEPTSPage userGoToRegistryEPTSPage(){
		click(registryLink);
		wait.until(ExpectedConditions.elementToBeClickable(registryEPTS));
		click(registryEPTS);
		return new RegistryEPTSPage(driver);
	}

	public void userGoToRegistryRequestPage(){
		click(requestLink);
		wait.until(ExpectedConditions.elementToBeClickable(registryRequestLnk));
		click(registryRequestLnk);
	}
}
