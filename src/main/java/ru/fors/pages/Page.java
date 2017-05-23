package ru.fors.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.fors.utils.PropertyLoader;

public class Page {

	WebDriver driver;
	WebDriverWait wait;
	protected WebDriverWait wait2;

	public By select2SearchField = By.className("select2-search__field");
	public By select2ResultField = By.className("select2-results__options");
	public By select2clearButton = By.className("select2-selection__clear");

	public Page(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Long.parseLong(PropertyLoader.loadProperty("wait")));
		wait2 = new WebDriverWait(driver, 5);
	}

	Date currentDate = new Date(System.currentTimeMillis());
	Date yesterday = new Date(System.currentTimeMillis()-86400000);
	Date competitionEndDate = new Date(System.currentTimeMillis()+259200000);
	DateFormat timeFormat = new SimpleDateFormat("HHmmss");
	DateFormat date = new SimpleDateFormat("dd.MM.YYYY");

	public boolean ensurePageLoaded(By element){
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			return true;
		} catch (Exception e){
			return false;
		}

	}

	public String getPageTitle(){
		return driver.getTitle();
	}
	
	public void type(By element, String string){
		driver.findElement(element).clear();
		driver.findElement(element).sendKeys(string);
	}
	
	public void click(By element){
		int count =0;
		while (count <5) {
			try {
				wait2.until(ExpectedConditions.elementToBeClickable(element));
				driver.findElement(element).click();
				break;
			} catch (Exception e) {
				System.out.println("Count: " + count + " click exception" );
				count = count + 1;
			}
		}
	}
	
	public String getElementText(By element){
		return driver.findElement(element).getText();
	}
	
	public String getUrl(){
		return driver.getCurrentUrl();
	}

	public void clickOn3Link(By element, By element1, By element2){
		int count = 0;
		while (count < 5) {
			try {
				click(element);
				wait2.until(ExpectedConditions.elementToBeClickable(element1));
				click(element1);
				wait2.until(ExpectedConditions.elementToBeClickable(element2));
				click(element2);
				break;
			} catch (Exception e) {
				System.out.println("Count: " + count + " click exception" );
                System.out.println(e);
				count = count + 1;
			}
		}
	}

	public void clickOn2Link(By element, By element1){
		int count = 0;
		while (count < 5) {
			try {
				click(element);
				wait2.until(ExpectedConditions.elementToBeClickable(element1));
				click(element1);
				break;
			} catch (Exception e) {
				System.out.println("Count: " + count + " click exception" );
				count = count + 1;
			}
		}
	}

	public void userSelectFromSelectList(By element, String value){
		boolean count = true;
		while(count){
			try{
				count = false;
				click(element);
				wait.until(ExpectedConditions.elementToBeClickable(select2SearchField));
				type(select2SearchField, value);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.textToBePresentInElementLocated(select2ResultField, value));
				Actions actions = new Actions(driver);
				actions.click(driver.findElement(By.className("select2-results__options"))).perform();
				wait2.until(ExpectedConditions.textToBePresentInElementLocated(element, value));
			} catch (Exception e){
				count = true;

			}
		}

	}

}
