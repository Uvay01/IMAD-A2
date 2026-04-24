# HackSlayer: The Ultimate Life-Hack Quiz

## Project Overview
HackSlayer is an Android application designed to test a user's "internet common sense." In a world full of viral rumors and life-hacks, this app challenges users to distinguish between genuine productivity tips (Hacks) and fake urban legends (Myths). 

The app was developed as part of my IT studies to demonstrate core Android development principles, including Activity navigation, state management, and multimedia integration.

---

## Features
* **Interactive Quiz Loop**: A flashcard-style system that iterates through a series of questions.
* **Real-time Feedback**: Immediate visual and audio cues telling the user if they were right or wrong.
* **Score Tracking**: A logic system that calculates the final score and passes it between screens.
* **Result Analysis**: A final score screen that provides personalized feedback and a "Review" button to see correct answers.
* **Restart Functionality**: A seamless loop allowing users to restart the quiz from the final screen.

---

## Technical Implementation
### Multimedia & Design
* **Custom Sounds**: Integrated specific audio files (`correct.mp3` and `wrong.mp3`) that trigger based on logic checks.
* **Lofi Aesthetic**: Used a dark-themed UI (`#1A1B26`) to create a modern, "Tsuki Terminal" inspired visual style.

### Version Control & GitHub Actions
* **GitHub Utilisation**: The project was managed using Git for version control. I used frequent commits to track my progress and ensure the safety of the source code.
* **CI/CD**: I implemented a GitHub Actions workflow (`build.yml`) that automatically builds the project using JDK 17 to verify code integrity on every push.

---

## How to Run the App
1. Clone the repository to your local machine.
2. Open the project in **Android Studio (Ladybug or newer)**.
3. Ensure you have **JDK 17** configured in your project settings.
4. Run the app on an **Android Emulator** or a physical device (API 33+ recommended).

---

## Student Information
* **Name**: Uvay Harichand
* **Student Number**: ST10477087
* **Module**: NTRODUCTION TO MOBILE APPLICATION DEVELOPMENT / IMAD5112
