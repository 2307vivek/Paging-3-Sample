# Paging-3-Sample
This app is created as a sample app which loads movies from the [TMDB] api, and uses the [Paging3] library to show it in a ```RecyclerView```

This project is under development.

# Development Setup
You require a [TMDB] api key to successfully build this app.
- [Register] a TMDB api key.
- Create a ```local.properties``` file in your project root folder.
- Add the api key in the ```local.properties```file as shown below.

```TMDB_API_KEY = "your-api-key"```

# Libraries used
- [Retrofit] to create network requests.
- [Koin] for dependency injection.
- [Paging3] for implementing paging.
- Kotlin [Coroutines]
- [Livedata] 

# Further Readings
- [How to Use the Paging Library in Android] 


[TMDB]: <https://www.themoviedb.org/>
[Register]: <https://developers.themoviedb.org/3>
[Retrofit]: <https://square.github.io/retrofit/>
[Koin]: <https://insert-koin.io/>
[Paging3]: <https://developer.android.com/topic/libraries/architecture/paging/v3-overview>
[Coroutines]: <https://kotlinlang.org/docs/reference/coroutines-overview.html>
[Livedata]: <https://developer.android.com/topic/libraries/architecture/livedata>
[How to Use the Paging Library in Android]: <https://proandroiddev.com/how-to-use-the-paging-3-library-in-android-5d128bb5b1d8>
