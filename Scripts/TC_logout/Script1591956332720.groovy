import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

try{
	WebUI.click(findTestObject('Object Repository/Page_Logout/profile'))
	WebUI.click(findTestObject('Object Repository/Page_Logout/Logout'))
	WebUI.closeBrowser()
}catch(Exception e){
	def testName = RunConfiguration.getExecutionSourceName().toString() +' Error run test'
	CustomKeywords.'globalFunction.fail.failure'(testName, FailureHandling.STOP_ON_FAILURE)
}