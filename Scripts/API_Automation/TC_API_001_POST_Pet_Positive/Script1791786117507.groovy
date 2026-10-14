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
import org.openqa.selenium.Keys as Keys

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import groovy.json.JsonSlurper
import java.util.concurrent.ThreadLocalRandom

import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import com.kms.katalon.core.testobject.TestObject


import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

// 1. Kirim request POST Pet dengan Global Variable / Dynamic Data
def response = WS.sendRequest(findTestObject('Object Repository/API/Petstore/POST_Pet'))

// 2. Assertion Status Code
WS.verifyResponseStatusCode(response, 200)

// 3. Parse dan Assertion Response Body
def jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

// Validasi bahwa ID di-generate oleh server dan nama sesuai
assert jsonResponse.id != null : "Pet ID tidak boleh null"
assert jsonResponse.name == GlobalVariable.petName : "Nama Pet tidak sesuai"
assert jsonResponse.status == GlobalVariable.petStatus : "Status Pet tidak sesuai"

// 4. Simpan ID yang ter-generate ke Global Variable untuk digunakan test case lain / E2E
GlobalVariable.petId = jsonResponse.id
println("Successfully created Pet with ID: " + GlobalVariable.petId)