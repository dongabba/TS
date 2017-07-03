package ru.fors.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Alexander Zhaleiko on 22.05.2017.
 */
public class CreateOTTSPage extends Page{
    CreateOTTSPage(WebDriver driver) {
        super(driver);
    }
    //===обязательные поля===
    private By docNumberFld = By.xpath("//input[@name=\"commonProperties:numberVersionContainer:number\"]");
    private By dateCreateFld = By.xpath("//input[@name=\"commonProperties:registrationDate\"]");
    private By dateRegistryEnter = By.xpath("//input[@name=\"commonProperties:registryEntryDate\"]");
    private By validDate = By.xpath("//input[@name=\"commonProperties:validFrom\"]");
    private By isMissingTrademarkChkBox = By.cssSelector("div[wicketpath=\"form_commonProperties_trademarksContainer\"]+div>label>span");
    private By trademarkSelectField = By.cssSelector("div[wicketpath=\"form_commonProperties_trademarksContainer_trademarks_repeater_0\"]>span>span>span");
    private By commercialNameField = By.xpath("//input[@name=\"commonProperties:commercialNamesContainer:commercialNames:repeater:0:textField\"]");
    private By typeField = By.xpath("//input[@name=\"commonProperties:modelNames:repeater:0:textField\"]");
    private By modificationField = By.xpath("//input[@name=\"commonProperties:modificationsContainer:modifications:repeater:0:modificationName\"]");
    private By category018selectField = By.cssSelector("div[wicketpath=\"form_commonProperties_technicalCategory_repeater_0\"]>div:nth-of-type(1)>div>div>span>span>span");
    private By ecologyClassField = By.cssSelector("div[wicketpath=\"form_commonProperties_ecologicalClassContainer_ecologicalClass_repeater_0\"]>div:nth-of-type(1)>div>span>span>span");
    private By sertOrgField = By.cssSelector("div[wicketpath=\"form_commonProperties_certificateAuthority_organizationContainer\"]>div:nth-of-type(2)>div>div>span>span>span");
    private By isManufacturerDelegateIsMissingChkBox = By.cssSelector("input[name=\"manufacturerDelegates:isMissing\"]+span");
    private By isManufacturerAssembliesIsMissingChkBox = By.cssSelector("input[name=\"manufacturerAssemblies:isMissing\"]+span");
    private By isAssemblyKitsSuppliersIsMissingChkBox = By.cssSelector("input[name=\"assemblyKitsSuppliers:isMissing\"]+span");
    private By baseVehicleField = By.cssSelector("input[name=\"approvalBaseVehicles:repeaterContainer:repeater:0:vehicleType\"]");
    private By vehicleWeightSelect = By.cssSelector("div[wicketpath=\"form_vehicleWeight_repeater_0\"]>div:nth-of-type(2)>div>div>span>span>span");
    private By forwardSuspensionDescription = By.cssSelector("textarea[name=\"vehicleGeneralCharacteristics:suspensions:repeater:0:fullSuspensionContainer:forwardSuspensionDescription\"]");
    private By forwardSuspensionDescription1 = By.cssSelector("textarea[wicketpath=\"form_vehicleGeneralCharacteristics_suspensions_repeater_0_fullSuspensionContainer_forwardSuspensionDescription\"]");
    private By rearSuspensionDescription = By.cssSelector("textarea[name=\"vehicleGeneralCharacteristics:suspensions:repeater:0:fullSuspensionContainer:rearSuspensionDescription\"]");
    private By unifiedConformitySignLocation = By.cssSelector("input[name=\"vehicleMarking:infoContainer:unifiedConformitySignLocation\"]");
    private By vin1 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:0:symbol\"]");
    private By vin2 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:1:symbol\"]");
    private By vin3 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:2:symbol\"]");
    private By vin4 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:3:symbol\"]");
    private By vin5 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:4:symbol\"]");
    private By vin6 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:5:symbol\"]");
    private By vin7 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:6:symbol\"]");
    private By vin8 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:7:symbol\"]");
    private By vin9 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:8:symbol\"]");
    private By vin10 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:9:symbol\"]");
    private By vin11 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:10:symbol\"]");
    private By vin12 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:11:symbol\"]");
    private By vin13 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:12:symbol\"]");
    private By vin14 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:13:symbol\"]");
    private By vin15 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:14:symbol\"]");
    private By vin16 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:15:symbol\"]");
    private By vin17 = By.cssSelector("input[name=\"vehicleMarking:infoContainer:vinMask:repeater:16:symbol\"]");
    private By saveButton = By.cssSelector("button[name=\"save\"]");
    private By deleteButton = By.cssSelector("button[wicketpath=\"form_delete\"]");
    private By statusNameField = By.cssSelector("span[wicketpath=\"form_header_status.name\"]");

    //===все поля====
    private By versionField = By.cssSelector("input[name=\"commonProperties:numberVersionContainer:version\"]");
    private By validDateToField = By.cssSelector("input[name=\"commonProperties:validTo\"]");
    private By addcommercialNameFieldButton = By.cssSelector("button[wicketpath=\"form_commonProperties_commercialNamesContainer_commercialNames_repeater_0_btnAdd\"]");
    private By applicantOrganizationSelect = By.cssSelector("div[wicketpath=\"form_applicantContainer_applicant_organizationContainer\"]>div:nth-of-type(4)>div>div>span>span>span"); //заявитель
    private By manufacturerOrganizationSelect = By.cssSelector("div[wicketpath=\"form_manufacturer_organizationContainer\"]>div:nth-of-type(4)>div>div>span>span>span"); //изготовитель
    private By manufacturerAssembliesAdd = By.cssSelector("a[wicketpath=\"form_manufacturerAssemblies_add\"]"); //добавить сборочный завод
    private By manufacturerAssembliesSelect = By.cssSelector("div[wicketpath=\"form_manufacturerAssemblies_repeater_0_organization_organizationContainer\"]>div:nth-of-type(4)>div>div>span>span>span"); //сборочный завод


    @Step("Проверяем открылась ли страница создания ОТТС")
    public boolean isCreateOTTSPageOpen(){
        return ensurePageLoaded(docNumberFld);
    }

    @Step("Пользователь вводит номер документа")
    public void userTypeDocNumber(){
        type(docNumberFld, "23052017_01");
    }

    @Step("Пользователь вводит дату оформления")
    public void userTypeRegistrationDate(){
        type(dateCreateFld, "23.05.2017");
    }

    @Step("Пользователь вводит дату внесения в единый реестр")
    public void userTypeRegistryEnterDate(){
        type(dateRegistryEnter, "23.05.2017");
    }

    @Step("Пользователь вводит дату срока действия")
    public void userTypeValidDate(){
        type(validDate, "23.05.2017");
    }

    @Step("Пользователь ставит отметку отсутствия марки")
    public void userCheckIsMissingTrademarkChkBox(){
        click(isMissingTrademarkChkBox);
    }

    @Step("Пользователь вводит марку")
    public void userTypeTradeMark(){
        userSelectFromSelectList(trademarkSelectField, "KAMAZ");
    }

    @Step("Пользователь вводит коммерческое наименование")
    public void userTypeCommercialName(){
        type(commercialNameField, "КамАЗ-6522");
    }

    @Step("Пользователь вводит тип")
    public void userTypeTypeName(){
        type(typeField, "6522");
    }

    @Step("Пользователь вводит модификацию")
    public void userTypeModificationName(){
        type(modificationField, "740.51-320, с КПП ZF, с КПП КамАЗ");
    }

    @Step("Пользователь вводит категорию ТС")
    public void userTypeCategory18(){
        userSelectFromSelectList(category018selectField, "N3G");
    }

    @Step("Пользователь вводит экологический класс")
    public void userTypeEcologyClass(){
        userSelectFromSelectList(ecologyClassField, "третий");
    }

    @Step("Пользователь вводит сертифицирующую организацию")
    public void userTypeSertOrg(){
        userSelectFromSelectList(sertOrgField, "ИЛ «ИНСАТ»");
    }

    @Step("Пользователь ставит отметку отсутствия представителей изготовителя")
    public void userCheckIsManufacturerDelegateIsMissingChkBox(){
        click(isManufacturerDelegateIsMissingChkBox);
    }

    @Step("Пользователь ставит отметку отсутствия представителей сборочных заводов")
    public void userCheckIsManufacturerAssembliesIsMissingChkBox(){
        click(isManufacturerAssembliesIsMissingChkBox);
    }

    @Step("Пользователь ставит отметку отсутствия представителей сборочных комлектов")
    public void userCheckIsAssemblyKitsSuppliersIsMissingChkBoxChkBox(){
        click(isAssemblyKitsSuppliersIsMissingChkBox);
    }

    @Step("Пользователь вводит Тип базового средства")
    public void userTypeBaseVehicle(){
        type(baseVehicleField, "6522");
    }

    @Step("Пользователь вводит вид массы")
    public void userTypevehicleWeight() throws InterruptedException {
        userSelectFromSelectList(vehicleWeightSelect, "Технически допустимая максимальная масса автопоезда");
        Thread.sleep(1000);
    }

    @Step("Пользователь вводит описание передней подвески")
    public void userTypeForwardSuspensionDescription()  {
        //click(forwardSuspensionDescription);
        //Actions actions = new Actions(driver);
        //actions.sendKeys((driver.findElement(By.cssSelector("textarea[name=\"vehicleGeneralCharacteristics:suspensions:repeater:0:fullSuspensionContainer:forwardSuspensionDescription\"]"))), "на двух полуэллиптических одноушковых рессорах").click().perform();
        type(forwardSuspensionDescription, "на двух полуэллиптических одноушковых рессорах");

    }

    @Step("Пользователь вводит описание задней подвески")
    public void userTypeRearSuspensionDescription() {
        type(rearSuspensionDescription, "балансирная, на двух полуэллиптических рессорах");

    }

    @Step("Пользователь вводит месторасположение единого знака")
    public void userTypeUnifiedConformitySignLocation(){
        type(unifiedConformitySignLocation, "рядом с табличкой изготовителя");
    }

    @Step("Пользователь вводит VIN")
    public void userTypeVIN(){
        type(vin1, "X");
        type(vin2, "T");
        type(vin3, "C");
        type(vin4, "6");
        type(vin5, "5");
        type(vin6, "2");
        type(vin7, "2");
        type(vin8, "0");
        type(vin9, "0");
        type(vin10, "8");
        type(vin11, "1");
        type(vin12, "2");
        type(vin13, "3");
        type(vin14, "4");
        type(vin15, "?");
        type(vin16, "?");
        type(vin17, "?");
    }

    @Step("Пользователь сохраняет ОТТС")
    public void userSaveOTTS(){
        click(saveButton);
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
    }

    @Step("Пользователь проверяет что статус ОТТС изменился на проект")
    public String userCheckOTTSStatus(){
        return getElementText(statusNameField);
    }

    //=== заполняем все поля ===
    @Step("Пользователь вводит версию")
    public void userTypeVersion(){
        type(versionField, "P2");
    }

    @Step("Пользователь указывает срок действия по")
    public void userTypevalidDateTo(){
        type(validDateToField, "31.12.2020");
    }
}
