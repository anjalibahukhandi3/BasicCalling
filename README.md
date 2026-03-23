# Basic Calling App

A simple Android calling simulator application built using Kotlin to demonstrate fundamental UI handling and state-driven architecture. 

## Features
* **Dial Pad Simulator:** A functional keypad that handles digit inputs, backspace, and clearing strings to simulate dialing numbers.
* **Outgoing Call Flow:** Mocks an outgoing phone call interface displaying the user's previously dialed number.
* **Incoming Call Flow:** A simulated incoming call fragment allowing users to answer or reject standard mocked "Unknown Caller" scenarios.
* **Active Call Interface:** A live call view featuring a ticking duration timer, a speaker toggle, and a mute button.

## Architecture & Approach

This project is structured around Google's recommended **MVVM (Model-View-ViewModel)** architectural pattern to ensure robust, clean, and easily testable code.

* **Presentation Layer (Fragments & ViewBinding):** The application relies entirely on modern single-activity architecture. Fragments represent unique screens (`DialPadFragment`, `ActiveCallFragment`, etc.). **ViewBinding** provides immediate null-safe compilation for updating layout properties without relying on `findViewById`.
* **State Management (ViewModel & LiveData):** All dynamic UI States are cleanly separated from Fragments into corresponding ViewModels (`DialPadViewModel`, `ActiveCallViewModel`). Data is passed back automatically via **LiveData** observation. Using `viewModelScope`, data naturally survives configuration changes like screen rotations.
* **Asynchronous Timers (Kotlin Coroutines):** The active call duration simulator avoids heavy threads or manual `Handlers`. Instead, it uses `viewModelScope.launch` paired with a simplified Kotlin Coroutine `delay(1000)` to elegantly update the ticking phone timer. 
* **Navigation Architecture (SafeArgs):** Transitions between views use the Android Navigation Component (`nav_graph.xml`). Data like the parsed dialed string is strictly typed and securely transmitted across Fragments using SafeArgs (`DialPadFragmentDirections`), eliminating unpredictable bundled arguments. 
* **Unit Testing:** Critical logic, tracking digits appending, clearing, and backspacing interactions are covered structurally utilizing the `InstantTaskExecutorRule`.
