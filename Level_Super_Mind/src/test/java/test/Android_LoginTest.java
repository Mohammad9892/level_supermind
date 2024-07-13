package test;

import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class Android_LoginTest extends Base_Test {
	
	 @Before
	    public void setUp() throws Exception {
	        setUp("Android");
	    }

	    @Test
	    public void testValidLoginWithEmail() {
	        MobileElement emailTab = driver.findElementById("emailTab");
	        emailTab.click();

	        MobileElement emailField = driver.findElementById("emailField");
	        MobileElement nextButton = driver.findElementById("nextButton");

	        String[] testData = getTestData("ValidLoginWithEmail").split(",");
	        emailField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement successMessage = driver.findElementById("successMessage");
	        assertEquals(testData[2], successMessage.getText());
	    }

	    @Test
	    public void testInvalidLoginWithEmail() {
	        MobileElement emailTab = driver.findElementById("emailTab");
	        emailTab.click();

	        MobileElement emailField = driver.findElementById("emailField");
	        MobileElement nextButton = driver.findElementById("nextButton");

	        String[] testData = getTestData("InvalidLoginWithEmail").split(",");
	        emailField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement errorMessage = driver.findElementById("errorMessage");
	        assertEquals(testData[2], errorMessage.getText());
	    }

	    @Test
	    public void testValidLoginWithPhone() {
	        MobileElement phoneTab = driver.findElementById("phoneTab");
	        phoneTab.click();

	        MobileElement phoneField = driver.findElementById("phoneField");
	        MobileElement nextButton = driver.findElementById("nextButton");

	        String[] testData = getTestData("ValidLoginWithPhone").split(",");
	        phoneField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement successMessage = driver.findElementById("successMessage");
	        assertEquals(testData[2], successMessage.getText());
	    }

	    @Test
	    public void testInvalidLoginWithPhone() {
	        MobileElement phoneTab = driver.findElementById("phoneTab");
	        phoneTab.click();

	        MobileElement phoneField = driver.findElementById("nextButton");

	        String[] testData = getTestData("InvalidLoginWithPhone").split(",");
	        phoneField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement errorMessage = driver.findElementById("errorMessage");
	        assertEquals(testData[2], errorMessage.getText());
	    }

	    @After
	    public void tearDown() {
	        super.tearDown();
	    }

}
