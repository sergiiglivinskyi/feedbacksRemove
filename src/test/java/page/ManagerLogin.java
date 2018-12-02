package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerLogin extends BasePage{
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='submitButton']")
    private WebElement submitButton;


    public ManagerLogin(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("qastartup.com.ua/manager/")
                && webDriver.getTitle().contains("MODX CMF Manager Login");
    }

    public MainPage login(String user, String password){
        userField.sendKeys(user);
        passwordField.sendKeys(password);
        submitButton.click();
        return PageFactory.initElements(webDriver, MainPage.class);
    }

}
