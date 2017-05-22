package ru.fors.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

public class LoginPage extends Page {
	


	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	private By usernameField = By.name("username");
	private By passwordField = By.name("password");
	private By loginButton = By.name("login");


	@Step("Пользователь входит в систему {0}")
	public MainPage userLogin(String username, String password){
		type(usernameField, username);
		type(passwordField, password);
		click(loginButton);
		return new MainPage(driver); 
		
	}
}
