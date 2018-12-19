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
import groovy.time.TimeCategory as TimeCategory

WebUI.openBrowser('')

use(TimeCategory, { 
        today = new Date()
    })

//System.out.println("HOY ES... -----> "+today.format("ddMMyyyyHHmmss"));
def texto = today.format('ddMMyyyyHHmmss')

WebUI.setViewPortSize(1024, 2048)

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.setText(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/input_Username_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/input_Password_password'), 
    'tEpeowUFFNw=')

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/button_Login'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/p_Login failed Please ensure t'), 
    30)) {
    //WebUI.takeScreenshot(('C:/Users/miguel.negrillo/Katalon Studio/capturas/fallos/' + texto) + '.png')
	WebUI.takeScreenshot("/home/ubuntu/workspace_katalon/capturas/fallos/"+texto+".png")
}

WebUI.setText(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/input_Username_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/input_Password_password'), 
    'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/button_Login'))

WebUI.selectOptionByValue(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare C'), 
    'Seoul CURA Healthcare Center', true)

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/input_Apply for hospital readm'))

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/input_Medicaid_programs'))

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/span_Visit Date (Required)_gly'))

for (def index : (0..1)) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/th_'),30)
	WebUI.takeScreenshot(('C:/Users/miguel.negrillo/Katalon Studio/capturas/calendario/'+index+'.png'))
	WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/th_'))
}

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/td_4'))

WebUI.setText(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/textarea_Comment_comment'), 'Este es un comentario')

WebUI.click(findTestObject('Object Repository/LoginExitoso/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.waitForPageLoad(10)

//WebUI.takeScreenshot(('C:/Users/miguel.negrillo/Katalon Studio/capturas/aciertos/' + texto) + '.png')

WebUI.takeScreenshot("/home/ubuntu/workspace_katalon/capturas/aciertos/"+texto+".png")

WebUI.closeBrowser()

