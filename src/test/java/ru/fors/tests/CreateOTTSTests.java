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
    public void userCreateElectronicOTTSTest(String username, String password, String role) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.userLogin(username, password);
        //assertTrue("Не совпадают роли пользователей", mainPage.getUserOrganisation().contains(role));
        RegistryOTTSPage registryOTTSPage = mainPage.userGoToRegistryOTTSPage();
        assertTrue("Не совпадают роли пользователей", registryOTTSPage.isRegistryOTTSPageLoaded().contains("Реестр ОТТС (ОТШ)"));
        CreateOTTSPage createOTTSPage = registryOTTSPage.userGoToCreateOTTSPage();
        assertTrue("Не совпадают роли пользователей", createOTTSPage.isCreateOTTSPageOpen());
        createOTTSPage.userTypeDocNumber();
        createOTTSPage.userTypeRegistrationDate();
        createOTTSPage.userTypeRegistryEnterDate();
        createOTTSPage.userTypeValidDate();
        createOTTSPage.userTypeTradeMark();
        createOTTSPage.userTypeCommercialName();
        createOTTSPage.userTypeTypeName();
        createOTTSPage.userTypeModificationName();
        createOTTSPage.userTypeCategory18();
        createOTTSPage.userTypeEcologyClass();
        createOTTSPage.userTypeSertOrg();
        createOTTSPage.userCheckIsManufacturerDelegateIsMissingChkBox();
        createOTTSPage.userCheckIsManufacturerAssembliesIsMissingChkBox();
        createOTTSPage.userCheckIsAssemblyKitsSuppliersIsMissingChkBoxChkBox();
        createOTTSPage.userTypeBaseVehicle();
        createOTTSPage.userTypevehicleWeight();
        createOTTSPage.userTypeForwardSuspensionDescription();
        createOTTSPage.userTypeRearSuspensionDescription();
        createOTTSPage.userTypeUnifiedConformitySignLocation();
        createOTTSPage.userTypeVIN();
        createOTTSPage.userSaveOTTS();
        assertTrue("Статус не изменился на проект", createOTTSPage.userCheckOTTSStatus().contains("проект"));
        //createOTTSPage.userCheckIsMissingTrademarkChkBox();

        Thread.sleep(5000);
        mainPage.userLogOut();
        Thread.sleep(5000);
    }
    @Test
    public void userGenerateOTTSTest() throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        MainPage mp = lp.userLogin("mega", "mega");
        RegistryOTTSPage registryOTTSPage = mp.userGoToRegistryOTTSPage();
        registryOTTSPage.userEraseStatusField();
        registryOTTSPage.userTypeInOttsSearchForm();
        registryOTTSPage.userClickSearchBtn();
        registryOTTSPage.userClickSearchCheckBox();
        CreateOTTSPage cop = registryOTTSPage.userCopyOTTS();
        cop.userCopyOtts();
    }
}
