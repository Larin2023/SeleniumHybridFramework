package testCases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {

        logger.info("URL is opened");

        LoginPage lp = new LoginPage(driver);

        lp.setUserName(username);
        logger.info("Entered username");

        lp.setPassword(password);
        logger.info("Entered password");

        lp.clickSubmit();

        // Assertion
        HomePage hp = new HomePage(driver);
        String headingText = hp.getHeadingText();

        if (headingText.equals("Institutes")) {
            Assert.assertTrue(true);
            logger.info("Login test passed");
        } else {
            captureScreen(driver, "loginTest");
            Assert.assertTrue(false);
            logger.info("Login test failed");
        }
    }
}
