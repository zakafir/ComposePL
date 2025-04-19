# 📝 ToDo Compose App

A simple and elegant ToDo application built with **Jetpack Compose** and **Kotlin**.

---

## 📸 Screenshots

| Home Screen | Adding a Task | Checked Task |
|-------------|----------------|----------------|
| ![Home](screenshots/home.png) | ![Add](screenshots/add.png) | ![Checked](screenshots/checked.png) |

---

## 🎞 Demo

Here’s a quick look at the app in action:

![Demo GIF](screenshots/todo-demo.gif)

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