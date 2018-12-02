package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

import static java.lang.Thread.sleep;

public class Tests extends BaseTest{

    @Test
    public void mainTest() throws InterruptedException{
        Assert.assertTrue(managerLogin.isPageLoaded(), "Manager Login Page is not loaded");
        MainPage mainPage = managerLogin.login("","");
        Assert.assertTrue(mainPage.isPageLoaded(), "Main PagePage is not loaded");
        sleep(1000);
        mainPage.switchToFrame();
        mainPage.clickOnPlusButtonRu();
        mainPage.clickOnPlusButtonFeedbacks();
        mainPage.removeFakeFeedbacks();
    }
}
