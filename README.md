# Appium BDD Cucumber Project

This project demonstrates how to use Appium with BDD (Behavior Driven Development) using Cucumber for automated testing of an Android application.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Tests](#running-the-tests)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Writing Tests](#writing-tests)

## Prerequisites

Before you begin, ensure you have the following installed:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk1.8-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [Appium Server](http://appium.io/docs/en/about-appium/getting-started/?lang=en)
- Android SDK
- An Android Emulator 
## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/yourrepository.git
   cd yourrepository
Install Maven dependencies:
mvn clean install
## Running the Tests
Start the Appium server: Appium gui server

Start the Android Emulator: Android studio

Run the tests using the TestNG suite:  mvn test -DsuiteXmlFile=testng.xml
throw testng.xml
mvn test
## Project Structure
src/test/java

runner: Contains the TestRunner class for running Cucumber tests.
steps: Contains the step definitions for the Cucumber scenarios.
utils: Contains utility classes like DriverFactory for managing the Appium driver.
pages: Contains the Page Object Model classes for the application under test.
src/test/resources
features: Contains the Cucumber feature files.
testng.xml: Configuration file for TestNG to specify which tests to run.

Configuration
DriverFactory Class
The DriverFactory class initializes the Appium driver with the desired capabilities. Update the capabilities as needed for your application and environment.

TestRunner Class
The TestRunner class is configured with Cucumber options. Update the features and glue paths if your project structure changes.

testng.xml
The testng.xml file configures the test suite and specifies the TestRunner class to execute.
