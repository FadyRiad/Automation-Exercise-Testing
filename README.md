# Automation-Exercise-Testing

This repository houses the end-to-end multi-tier testing framework designed for the comprehensive validation of the [Automation Exercise](https://automationexercise.com) website. Combining manual strategies, API verification, database validation, and a scalable UI automation framework, this project demonstrates real-world software quality assurance practices aligned with Agile Scrum.

📋 **Project Test Plan:** [Google Docs Link](https://docs.google.com/document/d/1nOFevCo_aQRiiZMVBBFFdCUTzvOarVknuc64802hm4M/edit?usp=sharing)

---

## 👥 Team Members

| Name | Role | DEPI ID |
| :--- | :--- | :--- |
| **Fady Riad Shokrallah** | **Team Leader & QA Automation Architect** <br> *(Environment Setup, Architecture Design & Task Allocation)* | 21136534 |
| **Habiba Mohamed Abdullah** | work Testing in all phases | 21077701 |
| **Ahmed Samy Mohamed** | work Testing in all phases | 21118179 |
| **Nouran Hossam Eldin Said** | work Testing in all phases | 21079183 |
| **Judy Abdelhalim Fathallah** | work Testing in all phases | 21120080 |
---

## 🛠️ Technology Stack & Tools

* **UI Automation:** Selenium WebDriver 4 (Java 11+)
* **Methodology Layer:** Cucumber BDD (Behavior-Driven Development)
* **Test Runner & Assertions:** TestNG
* **Design Pattern:** Page Object Model (POM)
* **API Validation:** Postman & Newman Command-Line Runner
* **Database Validation:** MySQL JDBC Driver
* **Performance Simulation:** Apache JMeter (Non-GUI Execution)
* **CI/CD Pipeline:** Jenkins
* **Defect Tracking:** Jira

---

## 📁 Repository Directory Structure

```text
├── .github/workflows/         # CI GitHub Actions configuration
├── src/
│   ├── main/java/
│   │   └── com/depi/framework/
│   │       ├── drivers/       # DriverManager (WebDriver configurations)
│   │       ├── pages/         # Page Objects (BasePage and Locators)
│   │       └── utils/         # DB Connection Helper, Custom Waits
│   └── src/test/
│       ├── java/
│       │   └── com/depi/tests/
│       │       ├── runners/   # Cucumber TestNG Runner
│       │       └── stepdefs/  # Cucumber step definitions
│       └── resources/
│           ├── features/      # Gherkin Scenario Feature Files
│           └── testdata/      # Data-driven Excel/CSV files
├── postman/
│   ├── collections/           # Postman Collection JSON exports
│   └── environments/          # Postman Environment configs
├── jmeter/
│   └── load_tests.jmx         # JMeter performance scripts
├── pom.xml                    # Maven dependency configuration
├── testng.xml                 # TestNG Suite Execution runner
└── README.md                  # Project Documentation
