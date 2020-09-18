import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

try{
	def amtDikirim = WebUI.getText(findTestObject('Object Repository/Page_Konfirmasi Transaksi/amount_terkonfirm'))
	println  amtDikirim
	WebUI.verifyEqual(amtDikirim, GlobalVariable.amtTotal)
	WebUI.scrollToElement(findTestObject('Object Repository/Page_Konfirmasi Transaksi/sudah transfer'), 1)
	WebUI.click(findTestObject('Object Repository/Page_Konfirmasi Transaksi/button_sudah_transfer'), FailureHandling.STOP_ON_FAILURE)
}catch(Exception e){
	def testName = RunConfiguration.getExecutionSourceName().toString() +' Error run test'
	CustomKeywords.'globalFunction.fail.failure'(testName, FailureHandling.STOP_ON_FAILURE)
}