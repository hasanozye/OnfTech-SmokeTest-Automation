# OnfTech Smoke Test Automation 🚀

This project is a **smoke test automation** framework for the OnfTech website, developed using **Java**, **Selenium WebDriver**, **Cucumber**, and **TestNG**. It is designed to verify the critical pages and components of the OnfTech website efficiently.

---

## Key Features 🌟

- **Selenium**: Automates browser interactions.
- **Cucumber BDD**: Test cases written in human-readable Gherkin format.
- **TestNG**: Parallel execution and reporting.
- **Page Object Model (POM)**: Simplifies test maintenance and uses DRY concepts for reusability.
- **Dynamic Driver Factory**: Supports multiple browsers (Chrome, Edge, Firefox).
- **Configurable Tests**: Easy configuration via `config.properties`.
- **Automatic Screenshots**: Captures screenshots after each test step or captures one screenshot per failed scenario(configurable).
- **ExtentReports**: Generates comprehensive test execution reports.
- **CI/CD**: Configured to run on cloud using Jenkins. 

---

## Project Structure 📁

```plaintext
OnfTech-SmokeTest-Automation
├── pom.xml                                 # Maven configuration file
├── src
│   ├── main/java
│   │   ├── driver                          # Browser driver management
│   │   │   ├── Browsers.java
│   │   │   ├── Driver.java
│   │   │   ├── DriverFactory.java
│   │   ├── readers/property                # Property file reader
│   │   │   └── PropertyReader.java
│   │   ├── utils                           # Utilities
│   │       ├── ScenarioContext.java
│   │       ├── Utils.java
│   ├── test/java
│   │   ├── pages                           # Page Object Model classes
│   │   │   ├── BaseTest.java
│   │   │   ├── HomePage.java
│   │   │   ├── ProductsPage.java
│   │   │   ├── ProductDetailPage.java
│   │   ├── runners                         # Cucumber runner
│   │   │   ├── Runner.java
│   │   ├── stepdefs                        # Step definitions for Cucumber
│   │       ├── Hooks.java
│   │       ├── HomePageSteps.java
│   │       ├── ProductsPageSteps.java
│   │       ├── ProductDetailPageSteps.java
│   ├── resources
│   │   ├── features/SmokeTest_BasicPageChecks.feature  # Feature file for smoke tests
│   │   ├── datafiles/config.properties                 # Configuration file
│   │   ├── extent.properties                           # ExtentReport settings
└── test-output                           # Test output, screenshots, and reports
```
## Screenshots 🖼️

![Test Automation Demo](C:\Users\e 15\IdeaProjects\Onftech\test-output\screenshots\embedded1.png)



