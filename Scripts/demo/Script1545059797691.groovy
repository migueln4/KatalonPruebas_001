import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.time.TimeCategory

WebUI.openBrowser('')

use(TimeCategory, {
	today = new Date()})

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

def texto = today.format("ddMMyyyyHHmmss");

WebUI.setViewPortSize(1024, 2048)

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Username_username'), 'usuario')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Password_password'), 'cDbzSVqoOR4ZSDO9XOFwfA==')

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Login'))

if (WebUI.verifyElementText(findTestObject('Object Repository/Page_CURA Healthcare Service/p_Login failed Please ensure t'), "Login failed! Please ensure the username and password are valid.")) {
	System.out.println("=========COINCIDE.=========")
} else {
	System.out.println("=========NO======COINCIDE.=========")
}

WebUI.takeScreenshot("/home/ubuntu/workspace_katalon/captura"+texto+"_OK.png")

//WebUI.takeScreenshot("C:/Users/miguel.negrillo/Katalon Studio/captura"+texto+".png")

WebUI.closeBrowser()

