
https://github.com/user-attachments/assets/9e49b05e-dbdd-4299-8aaa-34016b392055
# Weather Application for Android

This is a Weather Application for Android that provides real-time weather information using the Visual Crossing Weather API. The application displays the current temperature, feels-like temperature, humidity, and a 15-day forecast. It is built using modern Android development practices, including MVVM architecture, data binding, LiveData, Retrofit, and Gson.

## Features
- **Current Weather Information**: Displays the current temperature, feels-like temperature, and humidity based on the user’s location input.
- **15-Day Forecast**: Shows a 15-day weather forecast using a RecyclerView for a clean and scrollable display.
- **Search by Location**: Users can input the name of the location to get detailed weather information.
- **MVVM Architecture**: Follows the Model-View-ViewModel pattern to separate concerns and ensure a modular, maintainable codebase.
- **Data Binding & LiveData**: Uses data binding to efficiently bind UI components to data sources and LiveData to update the UI automatically when the data changes.
- **Retrofit & Gson Converter**: For handling API calls and converting JSON data into Java objects seamlessly.

## Video
[(Add screenshots of your app here to give users a visual overview.)](https://github.com/user-attachments/assets/9e49b05e-dbdd-4299-8aaa-34016b392055)

## Tech Stack
- **Language**: Java
- **Architecture**: MVVM (Model-View-ViewModel)
- **UI Components**: RecyclerView, CardView, ConstraintLayout
- **API**: Visual Crossing Weather API
- **Libraries**: 
  - [Retrofit](https://square.github.io/retrofit/) - For making API calls
  - [Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - For JSON parsing
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - For observing data changes
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding) - For binding UI components to data sources

## Features
- **Java** is a high-level, object-oriented programming language known for its platform independence, enabling developers to write code once and run it anywhere. It is widely used Android apps, and web development due to its robustness, security, and rich API.
- **MVVM architecture** an architectural pattern that improves the separation of tasks, it allows you to separate the logic of the user interface from the business logic of the app.
- **View Model** is a class in Android architecture that manages and stores UI-related data in a lifecycle-conscious way. It survives configuration changes like screen rotations, ensuring that data remains consistent and up-to-date without needing to reload or reinitialize.
- **LiveData** is an observable data holder class in Android that allows UI components to observe changes in data while adhering to the lifecycle of activities and fragments, ensuring updates only happen when the UI is active.
- **View Binding** View Binding is a feature in Android that generates binding classes for XML layouts, allowing you to easily access and interact with views without using findViewById(), reducing boilerplate code and improving type safety.
- **Retrofit** is a type-safe HTTP client for Android and Java, used to simplify network requests by converting API endpoints into interface methods and handling JSON responses with ease using converters like Gson.
- **Gson**  is a Java library used for converting Java objects to and from JSON format, making it easier to parse and serialize data from APIs or other sources into usable objects in your application.
- **RecyclerView** is a flexible and efficient Android widget for displaying large data sets in a scrollable list format, supporting dynamic item layouts and optimized memory usage through view recycling and view holders.

## Setup Instructions
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/weather-application.git
   ```
2. Open the project in **Android Studio**.
3. Add your Visual Crossing Weather API key to the project:
   - Go to `res/values/strings.xml` and replace `YOUR_API_KEY` with your actual API key:
     ```xml
     <string name="apiKey">YOUR_API_KEY</string>
     ```
4. Build and run the application on an Android emulator or a real device.

## Usage
1. Open the app, and enter the location name in the input field.
2. The app will display the current temperature, feels-like temperature, and humidity of the specified location.
3. The 15-day weather forecast will be shown below the current weather data.

## API Reference
- **Visual Crossing Weather API**: The app uses the Visual Crossing API to fetch weather data. You can learn more about it [here](https://www.visualcrossing.com/).

## Future Enhancements
- Add support for user location detection via GPS.
- Improve the UI to make it more visually pleasing and functional, providing a better user experience.
- Add different themes based on weather conditions (e.g., rainy, sunny).
- Include more weather details like wind speed, UV index, and precipitation levels.

## Contributing
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-branch
   ```
3. Make your changes and commit:
   ```bash
   git commit -m "Add new feature"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-branch
   ```
5. Create a pull request.

## Contact
For any questions or support, please contact [kr.neeraj105@gmail.com].
