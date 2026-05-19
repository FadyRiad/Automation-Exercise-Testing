# API Testing - Automation Exercise

## Overview
This folder contains the automated API test scripts and documentation for the [Automation Exercise](https://automationexercise.com/api) project. The testing phase covers 14 RESTful APIs, focusing on endpoints related to Products, Brands, User Authentication, and Account Management.

## Tools Used
* **Postman:** For API request creation, test assertions, and collection running.
* **JavaScript:** For writing test scripts and advanced assertions.

## Testing Strategy & Assertions
Our QA team implemented a comprehensive testing strategy. Each API request in this repository is thoroughly tested using Postman's `pm.test` framework. Our assertions cover:
* **HTTP Status Codes:** Verifying expected successful (e.g., 200 OK) and negative responses.
* **Response Time (Performance):** Ensuring server response times are strictly under 2000ms.
* **JSON Body Validation:** Parsing responses to verify logical response codes and exact string matching for error/success messages.
* **Negative Testing:** Intentionally sending invalid requests (e.g., missing parameters, unsupported HTTP methods like forcing POST on a GET endpoint) to validate the system's error handling and ensure it returns a `405 Method Not Allowed`.

## Folder Structure
To maintain a clean, collaborative, and organized workflow, each team member has a dedicated directory formatted as follows:

```text
3_API_Testing/
├── [Team Member Name]/
│   ├── File/                 # Contains the exported .json Postman Collection
│   └── Screenshots/          # Contains visual proof of Passed tests and Collection Runner reports
