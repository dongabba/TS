package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.CreateOTTSPage;
import ru.fors.pages.LoginPage;
import ru.fors.pages.MainPage;
import ru.fors.pages.RegistryOTTSPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

/**
 * Created by Alexander Zhaleiko on 22.05.2017.
 */
public class CreateOTTSTests extends TestBase{

    @BeforeMethod
    @Parameters({"username", "password"})
    public void testStatus(String username, String password){
        if (driver == null){
            init();
            //userLogin(username, password);
        } /*if (driver.getTitle().equals("SmartSport")){
			userLogin(username, password);
		}*/
    }

    @Features("Создание ОТТС (ОТШ)")
    @Stories("Создание ОТТС электронного типа")
    @Test
    @Parameters({"username", "password", "role"})
    public void userCreateElectronicOTTSTest(String username, String password, String role){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.userLogin(username, password);
        assertTrue("Не совпадают роли пользователей", mainPage.getUserOrganisation().contains(role));
        RegistryOTTSPage registryOTTSPage = mainPage.userGoToRegistryOTTSPage();
        assertTrue("Не совпадают роли пользователей", registryOTTSPage.isRegistryOTTSPageLoaded().contains("Реестр ОТТС (ОТШ)"));
        CreateOTTSPage createOTTSPage = registryOTTSPage.userGoToCreateOTTSPage();
        assertTrue("Не совпадают роли пользователей", createOTTSPage.isCreteOTTSPageOpen());
    }
}
