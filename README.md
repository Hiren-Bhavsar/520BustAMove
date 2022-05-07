
# [AppNameHere]

[AppNameHere] is an app designed to automatically adjust the 
content being listened to depending on the current activity of the user.


## Authors

- [Hiren Bhavsar](https://github.com/Hiren-Bhavsar)
- [Amandeep Singh](https://github.com/amandeep009-umass)


## Minimum Requirements

- Android Studio Bumblebee | 2021.1.1 Patch 3 Build
- Either an emulated or physical Android phone running Android 10 (or later)



## Run Locally

- Start Android Studio.

- Import the project from via git url.
```
File -> New -> Project from Version Control -> URL: https://github.com/Hiren-Bhavsar/520BustAMove
```
- Once loaded if using a physical device plug it in via USB and enable USB debugging.
- Either press the green triangle or use the keyboard shortcut "Shift + F10" to start the application.
## Lessons Learned
Though we were unable to fully complete our project, we learned a lot about
Android programming and UI design along the way. 

- Creating the UI for an Android app is relatively simple and intuitive,
any struggles while creating the UI was due to the Android Studio IDE.

- On the topic of Android Studio:
    - The IDE was relatively easy to use in order to get going, however when you first open it there is a lot going on and it can feel overwhelming.
    - If your code has an error the suggested fixes by the IDE usually are not very explanatory and are often ineffective in resolving the issue. 
    - When uploading resources to the IDE it is necessary to keep file names all lowercase, something not specified by the IDE. If a file name is not all lowercase the build will crash. If you try to just rename the file the IDE will still not recognize the file as being able to load, you have to delete the file, rename it, then re-add it.

- On the topic of Google’s documentation:
    - It’s well organized and easy to find what you need, if you know what you need.
    - It does a good job of stating when certain methods are deprecated.
    - It does not do a good job of telling you what to use instead.
    - Code snippets provided do not provide overall context for where the code should go (in a method, global, gradle file etc).
    - The “getting started” tutorials are very helpful and easy to follow.
