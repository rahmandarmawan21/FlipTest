import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.xbill.DNS.utils.hexdump

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')
WebUI.navigateToUrl('https://flip.id/login')
WebUI.waitForPageLoad(1000)
WebUI.click(findTestObject('Object Repository/Page_Login/field_email'))
WebUI.setText(findTestObject('Object Repository/Page_Login/field_email'), GlobalVariable.emailUsr)
WebUI.click(findTestObject('Object Repository/Page_Login/field_password'))
WebUI.setText(findTestObject('Object Repository/Page_Login/field_password'), GlobalVariable.passwordUsr)
WebUI.click(findTestObject('Object Repository/Page_Login/button_masuk'))
heloNameUser = WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Beranda/Halo'), 1000)
if(heloNameUser == true){
	WebUI.comment('Sukses Login')
}else{
	WebUI.comment('Failed Login')
	WebUI.closeBrowser()
}