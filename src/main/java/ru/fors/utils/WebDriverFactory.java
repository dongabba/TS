package ru.fors.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {
	
	public static final String CHROME = "chrome";
	public static final String FIREFOX = "firefox";
	public static final String INTERNET_EXPLORER = "ie";
	
	public static WebDriver getInstance(Browser browser) {

		WebDriver webDriver = null;
		String browserName = browser.getName();
		
		if (CHROME.equals(browserName)) {
			webDriver = new ChromeDriver();

		} else if (FIREFOX.equals(browserName)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			capabilities.setCapability(FirefoxDriver.PROFILE, profile);
			capabilities.setCapability(FirefoxDriver.MARIONETTE, false);
			webDriver = new FirefoxDriver(capabilities);

		} else if (INTERNET_EXPLORER.equals(browserName)) {
			webDriver = new InternetExplorerDriver();

		} return webDriver;
	}

}
