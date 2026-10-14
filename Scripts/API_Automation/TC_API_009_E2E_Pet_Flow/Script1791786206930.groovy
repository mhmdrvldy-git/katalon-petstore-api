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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper
import java.util.concurrent.ThreadLocalRandom
import com.kms.katalon.core.util.KeywordUtil

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import groovy.json.JsonSlurper

println("=== STARTING E2E PETSTORE FLOW ===")

// --- STEP 1: CREATE (POST) ---
def resPost = WS.sendRequest(findTestObject('Object Repository/API/Petstore/POST_Pet'))
WS.verifyResponseStatusCode(resPost, 200)

def parsedPost = new JsonSlurper().parseText(resPost.getResponseText())
GlobalVariable.petId = parsedPost.id
assert GlobalVariable.petId != null : "E2E Failed: Gagal mendapatkan ID pada proses POST"
println("[Step 1 PASSED] Pet created with ID: " + GlobalVariable.petId)


// --- STEP 2: READ (GET) ---
def resGet = WS.sendRequest(findTestObject('Object Repository/API/Petstore/GET_Pet_By_ID', [('petId') : GlobalVariable.petId]))
WS.verifyResponseStatusCode(resGet, 200)

def parsedGet = new JsonSlurper().parseText(resGet.getResponseText())
assert parsedGet.id == GlobalVariable.petId : "E2E Failed: ID GET tidak sesuai"
println("[Step 2 PASSED] Pet successfully retrieved.")


// --- STEP 3: UPDATE (PUT) ---
def resPut = WS.sendRequest(findTestObject('Object Repository/API/Petstore/PUT_Pet', [('petId') : GlobalVariable.petId]))
WS.verifyResponseStatusCode(resPut, 200)

def parsedPut = new JsonSlurper().parseText(resPut.getResponseText())
assert parsedPut.status == "sold" : "E2E Failed: Status gagal diubah menjadi sold"
println("[Step 3 PASSED] Pet successfully updated to 'sold'.")


// --- STEP 4: DELETE (DELETE) ---
def resDelete = WS.sendRequest(findTestObject('Object Repository/API/Petstore/DELETE_Pet_ById', [('petId') : GlobalVariable.petId]))
WS.verifyResponseStatusCode(resDelete, 200)
println("[Step 4 PASSED] Pet successfully deleted.")


// --- STEP 5: VERIFY DELETED (GET Negative) ---
def resGetAfterDelete = WS.sendRequest(findTestObject('Object Repository/API/Petstore/GET_Pet_By_ID', [('petId') : GlobalVariable.petId]))
WS.verifyResponseStatusCode(resGetAfterDelete, 404)
println("[Step 5 PASSED] Verified pet no longer exists (404 Not Found).")

println("=== E2E PETSTORE FLOW COMPLETED SUCCESSFULLY ===")