# Snaptrude Web Automation Framework

A robust Selenium WebDriver automation framework for testing the Snaptrude web application, showcasing modern test automation practices and design patterns.

## 🚀 Features

- **Page Object Model (POM)** implementation for better maintainability and reusability
- **Cross-browser testing** support (Chrome, Firefox, Edge)
- **Configurable test settings** through properties file
- **Explicit wait strategies** for reliable test execution
- **Comprehensive logging** for better debugging
- **Modular and scalable** architecture
- **Clean code structure** following Java best practices

## 🛠️ Technical Stack

- Java 8+
- Selenium WebDriver
- TestNG
- Maven
- WebDriverWait for explicit waits
- Properties file for configuration

## 📋 Test Coverage

The framework includes automated tests for key functionalities:

1. **Security Verification**
   - HTTPS connection validation
   - Secure protocol checks

2. **User Authentication**
   - Sign-up process
   - Form validation
   - User profile creation

3. **Application Features**
   - Project creation
   - Drawing tools
   - Canvas operations
   - Profile management

## 🏗️ Framework Structure

```
src/main/java/com/snaptrude/
├── config/         # Configuration management
├── pages/          # Page Object classes
├── tests/          # Test classes
└── utils/          # Utility classes
```

## 🚀 Getting Started

1. **Prerequisites**
   - Java JDK 8 or higher
   - Maven
   - Chrome/Firefox/Edge browser

2. **Configuration**
   - Update `config.properties` with your settings
   - Set browser preferences
   - Configure wait times

3. **Running Tests**
   ```bash
   mvn clean test
   ```

## 🎯 Key Features of the Framework

- **BasePage Class**: Common web element interactions
- **ConfigManager**: Centralized configuration management
- **TestUtils**: Reusable test utilities
- **BaseTest**: Common test setup and teardown
- **Page Objects**: Encapsulated page-specific operations

## 🔍 Best Practices Implemented

- Page Object Model design pattern
- Explicit wait strategies
- Proper exception handling
- Clean code architecture
- Modular test structure
- Comprehensive logging
- Cross-browser compatibility

## 📝 Notes

- Framework is designed to be easily extendable
- New test cases can be added following the existing pattern
- Page objects can be extended for new features
- Configuration can be modified without code changes
