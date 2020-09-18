import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

try{
	WebUI.click(findTestObject('Object Repository/Page_Beranda/Kirim Uang'))
	kirim = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Beranda/img__send-money-image'), 100)
	if(kirim == true){
		WebUI.click(findTestObject('Object Repository/Page_Beranda/img__send-money-image'))
	}
	//memilih rekening yang saya gunakan
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/list_bank_digunakan'))
	WebUI.sendKeys(findTestObject('Object Repository/Page_Kirim Uang/list_bank_digunakan'), GlobalVariable.useBank)
	WebUI.sendKeys(findTestObject('Object Repository/Page_Kirim Uang/list_bank_digunakan'), Keys.chord(Keys.ENTER))
	//memilih rekening tujuan dan isi nomor rekening
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/list_bank_tujuan'))
	WebUI.sendKeys(findTestObject('Object Repository/Page_Kirim Uang/list_bank_tujuan'), GlobalVariable.toBank)
	WebUI.sendKeys(findTestObject('Object Repository/Page_Kirim Uang/list_bank_tujuan'), Keys.chord(Keys.ENTER))
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/norek_tujuan'))
	WebUI.setText(findTestObject('Object Repository/Page_Kirim Uang/norek_tujuan'), GlobalVariable.noRek)
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/button_cek nama'))
	nameValid = WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Kirim Uang/cek_nama_benar'), 10)
	if(nameValid == true){
		WebUI.comment('Nama rekening tujuan valid')
	}
	namaTujuan = WebUI.getText(findTestObject('Object Repository/Page_Kirim Uang/nama_rekening_tujuan'))
	GlobalVariable.namaPemilik = namaTujuan
	//isi nominal uang
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/input_amount'))
	WebUI.setText(findTestObject('Object Repository/Page_Kirim Uang/input_amount'), GlobalVariable.amount)
	WebUI.scrollToElement(findTestObject('Object Repository/Page_Kirim Uang/pastikandatabenar'), 1)
	WebUI.click(findTestObject('Object Repository/Page_Kirim Uang/button_OK DATA SUDAH BENAR'), FailureHandling.STOP_ON_FAILURE)
}catch(Exception e){
	def testName = RunConfiguration.getExecutionSourceName().toString() +' Error run test'
	CustomKeywords.'globalFunction.fail.failure'(testName, FailureHandling.STOP_ON_FAILURE)
}