package test;

import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class IosLoginTest extends Base_Test{

	 @Before
	    public void setUp() throws Exception {
	        setUp("iOS");
	    }

	    @Test
	    public void testValidLoginWithEmail() {
	        MobileElement emailTab = driver.findElementByAccessibilityId("emailTab");
	        emailTab.click();

	        MobileElement emailField = driver.findElementByAccessibilityId("emailField");
	        MobileElement nextButton = driver.findElementByAccessibilityId("nextButton");

	        String[] testData = getTestData("ValidLoginWithEmail").split(",");
	        emailField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement successMessage = driver.findElementByAccessibilityId("successMessage");
	        assertEquals(testData[2], successMessage.getText());
	    }

	    @Test
	    public void testInvalidLoginWithEmail() {
	        MobileElement emailTab = driver.findElementByAccessibilityId("emailTab");
	        emailTab.click();

	        MobileElement emailField = driver.findElementByAccessibilityId("emailField");
	        MobileElement nextButton = driver.findElementByAccessibilityId("nextButton");

	        String[] testData = getTestData("InvalidLoginWithEmail").split(",");
	        emailField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement errorMessage = driver.findElementByAccessibilityId("errorMessage");
	        assertEquals(testData[2], errorMessage.getText());
	    }

	    @Test
	    public void testValidLoginWithPhone() {
	        MobileElement phoneTab = driver.findElementByAccessibilityId("phoneTab");
	        phoneTab.click();

	        MobileElement phoneField = driver.findElementByAccessibilityId("phoneField");
	        MobileElement nextButton = driver.findElementByAccessibilityId("nextButton");

	        String[] testData = getTestData("ValidLoginWithPhone").split(",");
	        phoneField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement successMessage = driver.findElementByAccessibilityId("successMessage");
	        assertEquals(testData[2], successMessage.getText());
	    }

	    @Test
	    public void testInvalidLoginWithPhone() {
	        MobileElement phoneTab = driver.findElementByAccessibilityId("phoneTab");
	        phoneTab.click();

	        MobileElement phoneField = driver.findElementByAccessibilityId("phoneField");
	        MobileElement nextButton = driver.findElementByAccessibilityId("nextButton");

	        String[] testData = getTestData("InvalidLoginWithPhone").split(",");
	        phoneField.sendKeys(testData[1]);
	        nextButton.click();

	        MobileElement errorMessage = driver.findElementByAccessibilityId("errorMessage");
	        assertEquals(testData[2], errorMessage.getText());
	    }

	    @After
	    public void tearDown() {
	        super.tearDown();
	    }

}
