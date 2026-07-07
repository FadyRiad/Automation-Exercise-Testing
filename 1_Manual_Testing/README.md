# Automation-Exercise-Testing — Manual Quality Assurance Documentation

This section of the repository documents the comprehensive Manual Testing Phase conducted on the [Automation Exercise](https://automationexercise.com) platform. Prior to implementing automation scripts, a rigorous manual verification process was executed aligned with Agile Scrum methodologies to establish a baseline of quality, map user journeys, and discover functional defects.

📋 **Project Test Plan & Manual Sheet:** [Google Sheets Link](https://docs.google.com/spreadsheets/d/1FH_q5yzC3kC6WnPnJHAnqKHo0TLNwrVfDxIwEIiwoeo/edit?usp=sharing)

---

## 🎯 Manual Testing Scope & Coverage

The manual testing lifecycle covered all core functional modules of the e-commerce platform, mapped across the following modules in our master sheet:

1. **Authentication & Identity Management:** * Sign Up with unique/existing credentials, Form validation, and Logout capabilities.
2. **Product Discovery:** * Search functionality, Category filtering, Brand filtering, and Product Detail Page (PDP) verification.
3. **Cart Operations:** * Adding/removing products, quantity modifications, and maintaining cart state during session transitions.
4. **Checkout & Order Placement:** * Address verification, payment gateway simulation, invoice downloading, and success screen validations.
5. **Customer Interactions:** * Contact Us form submission, file uploading functionality, and Subscription forms.

---

## 🛠️ Quality Assurance Artifacts inside the Sheet

The linked [Google Spreadsheet](https://docs.google.com/spreadsheets/d/1FH_q5yzC3kC6WnPnJHAnqKHo0TLNwrVfDxIwEIiwoeo/edit?usp=sharing) contains key professional QA sub-artifacts structured as follows:

### 1. Requirement Traceability Matrix (RTM)
* Maps every business requirement/user story of the Automation Exercise platform to its corresponding Test Case ID.
* Ensures 100% test coverage and guarantees no requirement is left unverified.

### 2. Test Case Specifications (TCS)
Every manual test case is meticulously documented with standard QA attributes:
* **Test Case ID / Module**
* **Test Scenario Description**
* **Pre-requisites**
* **Test Steps (Detailed Execution Steps)**
* **Test Data Used**
* **Expected Result vs. Actual Result**
* **Status** (Pass / Fail / Blocked)

### 3. Defect Log & Tracking Report
All bugs discovered during manual cycles were documented in a dedicated Defect Report containing:
* **Defect ID** & **Summary**
* **Severity** (Critical, Major, Minor, Cosmetic)
* **Priority** (High, Medium, Low)
* **Steps to Reproduce** & **Expected vs Actual Behavior**
* **Status Workflow** (New -> Open -> Fixed -> Ready for Re-test -> Closed)

---
