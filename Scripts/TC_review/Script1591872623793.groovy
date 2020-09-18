import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


try{
	WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Kirim Uang/ID TRANSAKSI'), 1)
	def nama = WebUI.getText(findTestObject('Object Repository/Page_Kirim Uang/nama_rekening_tujuan_review'))
	//WebUI.verifyEqual(nama, GlobalVariable.namaPemilik)
	def norek = WebUI.getText(findTestObject('Object Repository/Page_Kirim Uang/norek_tujuan_review'))
	WebUI.verifyEqual(norek, GlobalVariable.noRek)
	def amtTransferTotal = WebUI.getText(findTestObject('Object Repository/Page_Kirim Uang/total_transfer'))
	GlobalVariable.amtTotal = amtTransferTotal
	WebUI.scrollToElement(findTestObject('Object Repository/Page_Kirim Uang/Kenapa ada kode unik'), 1)
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/button_lanjut'))
	WebUI.scrollToElement(findTestObject('Object Repository/Page_Kirim Uang/syaratnketentuan'), 1)
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/btn_siapsetuju'))
}catch(Exception e){
	def testName = RunConfiguration.getExecutionSourceName().toString() +' Error run test'
	CustomKeywords.'globalFunction.fail.failure'(testName, FailureHandling.STOP_ON_FAILURE)
}