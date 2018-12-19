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
import groovy.time.TimeCategory

WebUI.openBrowser('')

use(TimeCategory, {
	today = new Date()})

//System.out.println("HOY ES... -----> "+today.format("ddMMyyyyHHmmss"));

def texto = today.format("ddMMyyyyHHmmss");

WebUI.setViewPortSize(1024, 2048)

WebUI.navigateToUrl('http://www.onetec.es/')

WebUI.click(findTestObject('Object Repository/Page_Onetec - Grupo Onetec/a_Aceptar'))

WebUI.click(findTestObject('Object Repository/Page_Onetec - Grupo Onetec/span_CONTACTO'))

WebUI.setText(findTestObject('Object Repository/Formulario/input_Nombre__contacto_WAR_con'), 'Nombre')

WebUI.setText(findTestObject('Object Repository/Formulario/input_Email__contacto_WAR_cont'), 'mail')

WebUI.setText(findTestObject('Object Repository/Formulario/input_Telfono__contacto_WAR_co'), '555666555')

WebUI.setText(findTestObject('Object Repository/Formulario/textarea_Comentarios__contacto'), ' Este es un comentario')

WebUI.click(findTestObject('Object Repository/Formulario/check'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Formulario/a_Hoja_fancybox-close'), 30)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Formulario/a_Hoja_fancybox-close'), 30)) {
 System.out.println("ENCONTRADO");
 WebUI.takeScreenshot("C:/Users/miguel.negrillo/Katalon Studio/xencontrada.png")
 WebUI.click(findTestObject('Object Repository/Formulario/a_Hoja_fancybox-close'))
}

WebUI.waitForPageLoad(10)

//WebUI.takeScreenshot("C:/Users/miguel.negrillo/Katalon Studio/capturaOneTec"+texto+".png")

WebUI.takeScreenshot("/home/ubuntu/workspace_katalon/capturaOneTec"+texto+".png")

WebUI.closeBrowser()

