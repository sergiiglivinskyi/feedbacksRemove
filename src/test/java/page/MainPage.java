package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

public class MainPage extends BasePage{
    @FindBy(xpath = "//img[@id='s1']")
    private WebElement plusButtonRu;

    @FindBy(xpath = "//img[@id='s10']")
    private WebElement plusButtonFeedbacks;

    @FindBy(xpath = "//div[@p='10']/span/span[@class='unpublishedNode']")
    private List<WebElement> unpublishedNodes;

    @FindBy(xpath = "//div[contains(@onclick, 'menuHandler(4)')]")
    private WebElement menuRemoveButton;


    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().contains("qastartup.com.ua/manager/")
                && webDriver.getTitle().contains("QA Start UP - (MODX CMS Manager)");
    }

    public void switchToFrame(){
        webDriver.switchTo().frame(1);
    }

    public void clickOnPlusButtonRu(){
        plusButtonRu.click();
    }

    public void clickOnPlusButtonFeedbacks(){
        plusButtonFeedbacks.click();
    }

    public void removeFakeFeedbacks() throws InterruptedException {
        Actions action = new Actions(webDriver);
        while(unpublishedNodes.size() != 0) {
            sleep(3000);
            for (WebElement webElement : unpublishedNodes) {
                ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView(true);", webElement);
                if (webElement.getText().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")) {
                    sleep(2000);
                    action.contextClick(webElement).build().perform();
                    sleep(1000);
                    menuRemoveButton.click();
                    webDriver.switchTo().alert().accept();
                    sleep(1000);
                    break;
                }
            }
            System.out.println(unpublishedNodes.size());
        }
    }



}
