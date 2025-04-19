# 📝 ToDo Compose App

A simple and elegant ToDo application built with **Jetpack Compose** and **Kotlin**.

---

## 📸 Screenshots

| Home Screen | Adding a Task | Checked Task |
|-------------|----------------|---------------|
| ![Home Screen](https://github.com/user-attachments/assets/ffcb1cdd-4846-4e8f-91e4-943192f083a3) | ![Adding a Task](https://github.com/user-attachments/assets/e467ea77-a4c8-4259-b792-c7a6b2f7c743) | ![Checked Task](https://github.com/user-attachments/assets/f7ca819d-80ee-42b1-8175-79ff0440053f) |

---

## 🎞 Demo

Here’s a quick look at the app in action:

![Demo]([Screen_recording_20250419_145608.webm](https://github.com/user-attachments/assets/273efc4a-37e3-4c8c-acfc-2d0fc86df629)


---

## 🚀 Features

- ✅ Add new ToDo items with a title and description
- 🧾 Display tasks in a scrollable list
- ☑️ Check/uncheck completed items
- 🗑 Delete tasks with one click
- 🔄 Real-time state updates using ViewModel and Flows

---

## 🛠 Tech Stack

- **Jetpack Compose** – for declarative UI
- **Kotlin** – language of choice
- **Android ViewModel** – lifecycle-aware data handling
- **State Management** – with Kotlin `StateFlow` and `collectAsStateWithLifecycle`

---

## 📱 UI Overview

### `TodoScreenRoot.kt`

- Initializes the `ToDoViewModel`
- Collects UI state and input
- Passes data and callbacks to `TodoScreen`

### `TodoScreen`

- Displays:
    - A list of ToDo items (`LazyColumn`)
    - Input fields for title and description
    - An "Add" button to submit new tasks

### `TodoItem`

- Each item contains:
    - Title and description (with line-through if checked)
    - A checkbox
    - A delete button

---
