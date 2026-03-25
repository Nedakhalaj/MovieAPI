# Movie Details API

An Android application that allows users to search for movies and view detailed information including title, IMDB rating, actors, and poster images using the IMDB API.

## Features

- **Movie Search**: Search for movies by name using a simple interface
- **Movie Details Display**: View comprehensive movie information including:
    - Movie title
    - IMDB rating/rank
    - Cast/actors
    - Poster image
- **Modern Android Architecture**: Built with MVVM pattern and best practices

## Technology Stack

- **Language**: Kotlin
- **UI Framework**: Android View with ViewBinding
- **Architecture**: MVVM (Model-View-ViewModel)
- **Networking**:
    - Retrofit 2.9.0 for HTTP client
    - Gson for JSON parsing
- **Image Loading**: Coil 2.3.0
- **Asynchronous Operations**: Kotlin Coroutines
- **Minimum SDK**: API 28 (Android 9.0)
- **Target SDK**: API 36

## API Integration

The app uses the IMDB API endpoint:
- **Base URL**: `https://imdb.iamidiotareyoutoo.com/`
- **Search Endpoint**: `/search?q={movie_name}`
- **Required Permission**: Internet access

## Project Structure
```
app/src/main/java/com/neda/movies/
├── data/
│   ├── api/
│   │   ├── ApiInterface.kt
│   │   └── ApiRepository.kt
│   └── models/
│       └── MovieApiModel.kt
└── view/
└── list/
├── MoviesListActivity.kt
└── MoviesListViewModel.kt
```


## How It Works

1. User enters a movie name in the search field
2. The ViewModel calls the API repository to search for the movie
3. Retrofit makes an HTTP GET request to the IMDB API
4. Response is parsed into Kotlin data classes using Gson
5. Movie details are displayed in the UI with poster image loaded via Coil

## Installation

1. Clone this repository
2. Open the project in Android Studio
3. Sync Gradle dependencies
4. Run the app on an Android device or emulator

## Requirements

- Android Studio Arctic Fox or later
- Android SDK API 28 or higher
- Internet connection for API access

## Contributing

Feel free to submit pull requests or create issues for bugs and feature requests.