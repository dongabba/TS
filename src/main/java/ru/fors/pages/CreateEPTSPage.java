package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

/**
 * Created by azhaleyko on 03.07.2017.
 */
public class CreateEPTSPage extends Page{
    public CreateEPTSPage(WebDriver driver) {
        super(driver);
    }
    private By vin6 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:5:symbol\"]");
    private By vin7 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:6:symbol\"]");
    private By vin8 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:7:symbol\"]");
    private By vin9 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:8:symbol\"]");
    private By vin10 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:9:symbol\"]");
    private By vin11 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:10:symbol\"]");
    private By vin12 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:11:symbol\"]");
    private By vin13 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:12:symbol\"]");
    private By vin14 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:13:symbol\"]");
    private By vin15 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:14:symbol\"]");
    private By vin16 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:15:symbol\"]");
    private By vin17 = By.cssSelector("input[name=\"identificationNumbers:vin:repeater:16:symbol\"]");
    private By engineNumb = By.cssSelector("input[name=\"identificationNumbers:engineNumbers:repeaterContainer:repeater:0:textField\"]");
    private By noShassi = By.cssSelector("input[name=\"identificationNumbers:chassisNumberMissing\"]+span");
    private By cabineNumb = By.cssSelector("input[name=\"identificationNumbers:bodyNumber\"]");
    private By noEmergencyServicesNumber = By.cssSelector("input[name=\"identificationNumbers:emergencyServicesNumberMissing\"]+span");
    private By manufactoryYearField = By.cssSelector("input[name=\"identificationNumbers:manufactoryYear\"]");
    private By category1968SelectFld = By.cssSelector("div[wicketpath=\"form_passportVehicle\"]>div:nth-of-type(1)>div:nth-of-type(2)>div:nth-of-type(2)>div>span>span>span");
    private By vehicleWeightFld = By.cssSelector("input[name=\"passportVehicle:vehicleWeightList:repeater:0:axleWeightValues:repeater:0:value\"]");
    private By placeOfEngineNumb = By.cssSelector("div[wicketpath=\"form_vehicleMarkingContainer_vehicleMarking_infoContainer_engineNumberContainer\"]>div:nth-of-type(1)>div>div>span>span>span");
    private By noSatelliteNavigationChkBox = By.cssSelector("input[name=\"managementInformation:satelliteNavigationEquipmentIdContainer:satelliteNavigationEquipmentId\"]+span");
    private By noTachographIdChkBox = By.cssSelector("input[name=\"managementInformation:tachographIdContainer:tachographId\"]+span");

    private int generateVinNumb(){
        Random rnd = new Random();
        return rnd.nextInt(9);

    }

    public void userTypeVIN(){
        type(vin6, String.valueOf(generateVinNumb()));
        type(vin7, String.valueOf(generateVinNumb()));
        type(vin8, String.valueOf(generateVinNumb()));
        type(vin9, String.valueOf(generateVinNumb()));
        type(vin10, String.valueOf(generateVinNumb()));
        type(vin11, String.valueOf(generateVinNumb()));
        type(vin12, String.valueOf(generateVinNumb()));
        type(vin13, String.valueOf(generateVinNumb()));
        type(vin14, String.valueOf(generateVinNumb()));
        type(vin15, String.valueOf(generateVinNumb()));
        type(vin16, String.valueOf(generateVinNumb()));
        type(vin17, String.valueOf(generateVinNumb()));

    }

    public void userTypeEngineNumber(){
        Random rnd = new Random();
        type(engineNumb, "A"+String.valueOf(rnd.nextInt(8999999)+1000000));
    }

    public void userCheckNoShassi(){
        click(noShassi);
    }

    public void userTypeCabineNumb(){
        Random rnd = new Random();
        type(cabineNumb, "JTJHK"+String.valueOf(rnd.nextInt(89)+10)+"U"+String.valueOf(rnd.nextInt(899999999)+100000000));
    }

    public void userCheckNoEmergencyServicesNumber(){
        click(noEmergencyServicesNumber);
    }

    public void userTypeManufactoryYear(){
        type(manufactoryYearField, "2017");
    }

    public void userSelectCategory1968(){
        userSelectFromSelectList(category1968SelectFld, "категория C");
    }

    public void userTypeVehicleWeight(){
        Random rnd = new Random();
        type(vehicleWeightFld, String.valueOf(rnd.nextInt(5000)+10000));
    }

    public void userSelectPlaceOfEngineNumb(){
        userSelectFromSelectList(placeOfEngineNumb, "на блоке цилиндров двигателя");
    }

    public void userNoSatelliteNavigationChkBox(){
        click(noSatelliteNavigationChkBox);
    }

    public void userNoTachographIdChkBox(){
        click(noTachographIdChkBox);
    }

}
