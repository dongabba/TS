package ru.fors.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.fors.pages.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.junit.Assert.assertTrue;

/**
 * Created by azhaleyko on 03.07.2017.
 */
public class CreateEptsPage extends TestBase{
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

    @Features("Создание ЭПТС (ЭПШТС)")
    @Stories("Создание ЭПТС")
    @Test
    @Parameters({"username", "password", "role"})
    public void userCreateEPTSTest(String username, String password, String role) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.userLogin(username, password);
        assertTrue("Не совпадают роли пользователей", mainPage.getUserOrganisation().contains(role));
        RegistryEPTSPage registryEPTSPage = mainPage.userGoToRegistryEPTSPage();
        //assertTrue("Не совпадают роли пользователей", registryOTTSPage.isRegistryOTTSPageLoaded().contains("Реестр ОТТС (ОТШ)"));
        CreateEPTSPage createEPTSPage = registryEPTSPage.userOpenCreateEPTSPage();
        createEPTSPage.userTypeVIN();
        createEPTSPage.userTypeEngineNumber();
        createEPTSPage.userCheckNoShassi();
        createEPTSPage.userTypeCabineNumb();
        createEPTSPage.userCheckNoEmergencyServicesNumber();
        createEPTSPage.userTypeManufactoryYear();
        createEPTSPage.userSelectCategory1968();
        createEPTSPage.userTypeVehicleWeight();
        createEPTSPage.userSelectPlaceOfEngineNumb();
        createEPTSPage.userNoSatelliteNavigationChkBox();
        createEPTSPage.userNoTachographIdChkBox();
        Thread.sleep(5000);
    }
}
