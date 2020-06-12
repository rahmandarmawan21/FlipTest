import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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