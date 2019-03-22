package com.itest.bean;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Itest_register_bean{ 
    WebDriver driver;
    public Itest_register_bean(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath ="//*[@id='username']")
    public WebElement inputUserName;
    @FindBy(xpath ="//*[@id='password_input']")
    public WebElement inputPassword;
    @FindBy(xpath ="//*[@id='login_button']")
    public WebElement buttonLogin;
}