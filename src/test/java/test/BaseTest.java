package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.ManagerLogin;

public class BaseTest {

    WebDriver webDriver;
    ManagerLogin managerLogin;

    @BeforeMethod
    public void beforeMethod(){
        webDriver = new FirefoxDriver();
        webDriver.navigate().to("http://login:password@qastartup.com.ua");
        managerLogin = PageFactory.initElements(webDriver, ManagerLogin.class);
    }

    @AfterMethod
    public void afterMethod(){
        webDriver.quit();
    }
}