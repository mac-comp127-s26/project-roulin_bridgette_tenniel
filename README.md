# President Trump’s 2020 Adventure

## Overview

President Trump’s 2020 Adventure is a narrative-based strategy game created as the final project for COMP 127.

The player takes control of Donald Trump during the final five days before the 2020 U.S. presidential election. The story takes place in an alternate timeline where the election has already been lost, but the player suddenly wakes up five days earlier with a chance to change the result.

Throughout the game, the player manages three statistics:

- Support
- Stability
- Mood

Each day includes:
- reacting to news events,
- attending campaign activities,
- and choosing one strategic action:
  - Rally
  - Donor Meeting
  - Staff Meeting

After Day 5, the game determines one of four endings depending on the player’s final statistics.

The project was built entirely in Java using JavaFX for the user interface. Story events, dialogue, and endings are stored using nested HashMaps and ArrayLists.

---

# Software Requirements

| Software | Version |
|---|---|
| OpenJDK | 21.0.2 LTS or newer |
| Visual Studio Code | 1.118.1 or newer |
| JavaFX SDK | 21.0.2 |
| Extension Pack for Java | Latest |

---

# Setup Instructions

## 1. Install OpenJDK

Download OpenJDK 21:

https://jdk.java.net/21/

Verify the installation:

```bash
java -version
javac -version
```

---

## 2. Install VS Code

Download VS Code:

https://code.visualstudio.com/

Then install the **Extension Pack for Java** from the Extensions tab.

---

## 3. Install JavaFX

If your JDK does not include JavaFX:

1. Download JavaFX SDK 21.0.2:
   
https://gluonhq.com/products/javafx/

2. Extract the SDK somewhere on your computer.

Example:

```bash
~/javafx-sdk-21.0.2
```

---

## 4. Clone the Repository

```bash
git clone https://github.com/mac-comp127-s26/project-roulin_bridgette_tenniel.git
cd project-roulin_bridgette_tenniel
```

---

## 5. Open the Project

1. Open VS Code.
2. Select **File → Open Folder**.
3. Open the cloned repository folder.

Wait for the Java extensions to finish loading.

---

## 6. Configure JavaFX

If JavaFX is not bundled with your JDK, create:

```text
.vscode/launch.json
```

Add:

```json
{
    "type": "java",
    "name": "Launch Main",
    "request": "launch",
    "mainClass": "Main",
    "vmArgs": "--module-path /path/to/javafx-sdk-21.0.2/lib --add-modules javafx.controls,javafx.fxml"
}
```

Replace the module path with your own JavaFX SDK location.

Example on macOS:

```text
/Users/yourname/javafx-sdk-21.0.2/lib
```

---

## 7. Run the Game

1. Open `Main.java`.
2. Click the **Run** button or right-click and select **Run Java**.

---

# Screenshots

## Main Menu

![Main Menu](https://github.com/mac-comp127-s26/project-roulin_bridgette_tenniel/blob/main/assets/main-menu.png)

---

## Gameplay

![Gameplay Scene](https://github.com/mac-comp127-s26/project-roulin_bridgette_tenniel/blob/main/assets/gameplay-scene.png)

---

## Ending Screen

![Ending Screen](https://github.com/mac-comp127-s26/project-roulin_bridgette_tenniel/blob/main/assets/outlook.png)

---

# Presentation Video

https://drive.google.com/file/d/1AIyiLH94TWavmZl3s4Q5IM1VavAh-3Dg/view?usp=sharing

---

# Presentation Slides

https://drive.google.com/file/d/1xcoYcmCDUd2xDuwVZmHXPDcQsOnfqT2z/view?usp=sharing

---

# Known Limitations

- No save/load system
- Story content is hard-coded in `StoryData.java`
- No external JSON or XML support
- Limited handling for rapid repeated input
- UI layout is optimized for a fixed window size

---

# References

- COMP 127 course materials
- JavaFX Documentation  
  https://openjfx.io/

- Java SE Documentation
- GitHub Markdown Guide  
  https://docs.github.com/en/get-started/writing-on-github

- Awesome README  
  https://github.com/matiassingers/awesome-readme

---

# Credits

Developed by:

- Ruolin Shen
- Tianqi Zhao
- Bridgette Mi

COMP 127 Final Project



