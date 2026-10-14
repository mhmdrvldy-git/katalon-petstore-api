# Katalon Petstore API Automation

Automated API testing framework built using **Katalon Studio** to test the Swagger Petstore API (`https://petstore.swagger.io/`).

## 🚀 Project Overview
This repository contains automated regression test suites covering CRUD operations and End-to-End (E2E) flows for the Petstore API, including positive and negative test scenarios.

## 🛠️ Tech Stack
- **Test Engine:** Katalon Studio
- **Language:** Groovy
- **Target API:** Swagger Petstore

## 📂 Project Structure
- `Object Repository/API/Petstore/`: Contains all HTTP request definitions (GET, POST, PUT, DELETE).
- `Test Cases/API_Automation/`: Contains individual test scripts with assertions.
- `Test Suites/`: Contains organized execution suites (`TS_API_Regression`).

## ⚙️ How to Run
1. Open Katalon Studio and clone/open this project.
2. Navigate to **Test Suites** > `TS_API_Regression`.
3. Click the **Run** button or execute via CLI/Katalon Runtime Engine (KRE).

## 📊 Test Coverage & Scenarios
- **POST /pet (Positive & Negative):** Create new pet records and handle invalid payloads.
- **GET /pet/{petId} (Positive & Negative):** Retrieve pet details by ID and handle non-existent IDs (404/405 validation).
- **PUT /pet (Positive & Negative):** Update pet data and validate error responses.
- **DELETE /pet/{petId} (Positive):** Clean up and remove test pet records.