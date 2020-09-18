import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

try{
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
}catch(Exception e){
	def testName = RunConfiguration.getExecutionSourceName().toString() +' Error run test'
	CustomKeywords.'globalFunction.fail.failure'(testName, FailureHandling.STOP_ON_FAILURE)
}
