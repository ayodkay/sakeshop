# Sake Shop Finder

A simple Android application that displays a list of local sake shops and their details. This project is built with Jetpack Compose and follows clean architecture principles.

## Architecture

The application is structured into three main modules:

-   **`:app`**: The presentation layer, containing UI elements built with Jetpack Compose, ViewModels, and navigation.
-   **`:data`**: The data layer, responsible for providing data to the application. It includes data models, repositories, and data sources.
-   **`:domain`**: The domain layer, which holds the core business logic of the application in the form of use cases.

This modular approach ensures a separation of concerns, making the codebase more maintainable, scalable, and testable.

## Dependencies

-   **Jetpack Compose**: For building the UI.
-   **Navigation Compose**: For handling navigation between screens.
-   **ViewModel Compose**: To use ViewModels with Compose.
-   **Coil**: For asynchronous image loading.
-   **Gson**: For parsing the JSON data.
-   **JUnit & Mockito**: For unit testing.
    -.  **Compose UI Test**: For UI testing.

## Setup and Running the App

1.  Clone the repository.
2.  Open the project in Android Studio.
3.  Place the `sake_shops.json` file in the `app/src/main/assets` directory.
4.  Build and run the application on an Android emulator or a physical device.

## Thought Process

The primary goal was to create a well-structured and maintainable application. The choice of a modular, clean architecture was deliberate to separate concerns and improve testability.

-   **Data Layer**: A `SakeShopRepository` was created to abstract the data source. This makes it easy to switch to a remote API in the future without affecting the rest of the application.
-   **Domain Layer**: Use cases encapsulate the business logic, making it independent of the UI and data layers.
-   **Presentation Layer**: Jetpack Compose was used for a modern, declarative UI. ViewModels provide data to the UI and survive configuration changes. Navigation is handled by Navigation Compose for a seamless user experience.
-   **Testing**: Unit tests for ViewModels and use cases ensure the logic is correct. UI tests verify that the Composable functions behave as expected.