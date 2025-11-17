# Appium-Automation-Awdenegest

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![Appium](https://img.shields.io/badge/Appium-1.26-orange)](https://appium.io/)
[![TestNG](https://img.shields.io/badge/TestNG-7.11.0-green)](https://testng.org/doc/)

## Overview
This repository contains a professional Appium automation suite for the **AwdeNegest Amharic Name Calculator** Android app.  
The suite demonstrates robust mobile testing using Page Object Model (POM), explicit waits, and TestNG DataProvider for parameterized testing. Unicode-safe assertions ensure accurate verification of Amharic characters.

---

## Features
- Page Object Model (POM) implementation for maintainable code
- Explicit waits for reliable element handling
- DataProvider to test multiple sets of Amharic names
- Unicode-safe validations for Amharic result text
- Scrolls through detail pages using `UiScrollable`
- Refreshes input fields and validates clearing
- Console logging of results
- Generates TestNG HTML reports for detailed test execution results


---

## Project Structure
Appium-Automation-Awdenegest/
- src/
  - main/
    - java/
      - com.awdenegest.appium.pages
        - MainPage.java
    - resources/
  - test/
    - java/
      - com.awdenegest.appium.tests
        - AwdeNegestTest.java
    - resources/
- pom.xml
- testng.xml
- README.md

---

## Getting Started

### Prerequisites
- Java 17 or later
- Appium Server 1.26 or higher
- Android SDK installed
- Connected Android device or emulator
- Maven (optional, if using Maven project structure)
- IDE: Eclipse or IntelliJ IDEA

### Installation
1. Clone the repository:
```bash
git clone https://github.com/R-kos77/Appium-Automation-Awdenegest.git
Open the project in your IDE.

Ensure the Appium server is running and a device/emulator is connected.

Run tests via testng.xml or directly from the IDE.

Example Test Run
The suite performs the following steps:

Inputs first and mother names in Amharic.

Clicks the calculate button and verifies the result includes "ኮከብ".

Opens the detail page and scrolls to the bottom.

Navigates back and refreshes the input fields.

Validates that input fields are cleared or showing correct hint text.

Multiple test data sets are handled automatically via TestNG DataProvider.

Dependencies
Appium Java Client

Selenium WebDriver

TestNG

Author
Robel Kiros
GitHub: R-Kos77
Email: robelalbeta@gmail.com
