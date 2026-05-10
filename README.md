# President Trump's 2020 Adventure
## A Narrative-Driven Strategy Simulation Game

---

## 1. Executive Summary

**President Trump's 2020 Adventure** is a turn-based narrative strategy game developed as the final project for COMP 127. The game places the player in the role of Donald Trump during the final five days of the 2020 United States presidential election. The narrative premise operates on an alternate-history conceit: the player awakens in a timeline where the election has already been lost, but is granted the opportunity to relive the final five days preceding Election Day with full knowledge of the original outcome.

The project demonstrates the application of object-oriented design principles, finite-state machine architecture, and data-driven narrative systems within the context of interactive media development.

---

## 2. Game Design & Mechanics

### 2.1 Core Gameplay Loop

The game operates on a strictly linear temporal structure spanning five in-game days. Each day is subdivided into three distinct phases, creating a structured decision-making environment:

| Phase | Description | Player Agency |
|-------|-------------|---------------|
| **Morning Twitter** | The player reviews breaking news and selects a rhetorical response | High — binary or tertiary choice structure |
| **Fixed Events** | Scripted narrative events (e.g., debates, press conferences, external crises) | None — these advance the plot and may apply stat modifiers |
| **Action Phase** | The player selects one strategic action to execute during the afternoon/evening | High — constrained by daily uniqueness rules |

### 2.2 Player Statistics & State Tracking

The game employs a three-dimensional state vector to quantify the player's strategic position:

- **Support** (`double` or `int`, 0–100): Represents aggregate public approval, base enthusiasm, and electoral momentum. This is the primary victory condition metric.
- **Stability** (`double` or `int`, 0–100): Measures campaign organizational coherence, staff morale, and operational readiness. Critical for preventing catastrophic failure states.
- **Mood** (`double` or `int`, 0–100): Represents the player character's emotional state, ranging from composed to volatile. Affects narrative options and may gate certain decision branches.

All statistics are bounded within a normalized range and are modified by player decisions, random narrative events, and inter-stat dependencies.

### 2.3 Action Economy & Constraints

During the Action Phase, the player must select exactly one action from the following pool:

| Action | Primary Effect | Secondary Effect | Risk Profile |
|--------|---------------|-------------------|--------------|
| **Rally** | +Support (significant) | -Stability (moderate), +Mood (moderate) | High variance; may trigger unpredictable events |
| **Donors** | +Support (moderate, immediate) | Neutral | Low risk, low reward |
| **Staff Meeting** | +Stability (significant) | -Mood (moderate) | Defensive; prevents instability cascades |

**Constraint:** The same action cannot be selected twice within a single day, forcing strategic diversification and preventing dominant strategies.

### 2.4 End-State Evaluation System

Upon completion of Day 5, the game evaluates the final state vector against a deterministic condition matrix to assign one of four narrative endings:

| Ending | Support Condition | Stability Condition | Mood Condition | Narrative Description |
|--------|-------------------|---------------------|----------------|----------------------|
| **Victory** | High (≥ threshold) | High (≥ threshold) | Any | The player secures an electoral comeback and wins the presidency |
| **War** | Any | Critical Low (≤ threshold) | Any | The player rejects the election results, triggering a constitutional crisis |
| **Lose** | Low (< threshold) | Any | Composed (≥ threshold) | The player concedes gracefully and accepts defeat |
| **Sad** | Low (< threshold) | Any | Bitter (< threshold) | The player loses and exhibits profound emotional distress |

---

## 3. Software Architecture

### 3.1 Technology Stack

| Layer | Technology | Version Requirement |
|-------|-----------|---------------------|
| Language | Java | SE 11 or newer |
| UI Framework | JavaFX | Bundled with JDK 11+ or standalone |
| Build System | Platform-agnostic (IntelliJ IDEA / Eclipse / VS Code) | N/A |
| Data Structure | Standard Collections (`java.util`) | N/A |

### 3.2 Core Class Architecture

The codebase follows a Model-View-Controller (MVC) pattern with data-driven narrative content.

#### `StoryData.java` — The Narrative Repository
- **Responsibility:** Static factory class responsible for constructing and populating the master narrative graph.
- **Implementation:** Utilizes nested `HashMap<String, Object>` and `ArrayList<Choice>` structures to store scene text, choice labels, stat modifiers, and scene transition logic.
- **Key Method:** `createStory()` — initializes the complete 5-day narrative tree, action pool, and ending condition matrix at runtime.
- **Design Rationale:** Decoupling narrative content from game logic allows non-programmers to modify story branches without altering core engine code.

#### `GameState.java` — The Model Layer
- **Responsibility:** Encapsulates the entire mutable state of the game session.
- **Attributes:**
  - `int support`, `int stability`, `int mood`
  - `int currentDay`
  - `Set<String> actionsTakenToday` — enforces daily action uniqueness constraint
  - `String currentSceneId` — pointer into the narrative graph
- **Methods:** Getters, setters with bounds checking, daily reset logic, and end-state evaluation predicates.

#### `GameController.java` — The Controller Layer
- **Responsibility:** Mediates between user input, game state mutations, and UI updates.
- **Functions:**
  - Handles JavaFX `ActionEvent` triggers from UI buttons
  - Applies stat modifiers from selected choices
  - Navigates the narrative graph by resolving scene IDs
  - Triggers scene transitions and ending sequences
  - Enforces game rules (e.g., action uniqueness validation)

### 3.3 Data Flow & Execution Sequence

```
[Application Launch]
    ↓
[StoryData.createStory()] → Loads narrative graph into memory
    ↓
[GameState instantiation] → Initializes default stats (Day 1)
    ↓
[JavaFX Stage Setup] → Renders initial scene from master map
    ↓
[Player Input] → GameController.handleChoice(choiceId)
    ↓
[Stat Modification] → GameState.applyModifiers(deltaSupport, deltaStability, deltaMood)
    ↓
[Scene Resolution] → Lookup nextSceneId in narrative graph
    ↓
[UI Update] → JavaFX scene transition
    ↓
[Day Advancement Check] → If Day 5 complete → Evaluate End-State Conditions
    ↓
[Ending Scene] → Display final narrative outcome
```

---

## 4. Narrative System Design

### 4.1 Content Structure

The narrative is organized as a directed graph where nodes represent scenes and edges represent player choices or scripted transitions. Each node contains:

- **Scene ID:** Unique identifier (e.g., `"day3_morning_twitter"`)
- **Display Text:** Narrative content presented to the player
- **Choice Array:** Available options, each containing:
  - Display label
  - Stat delta vector `(ΔSupport, ΔStability, ΔMood)`
  - Target scene ID
- **Phase Metadata:** Tags indicating `MORNING`, `FIXED`, or `ACTION` phase

### 4.2 Branching Logic

While the temporal structure is linear (Day 1 → Day 5), the narrative graph permits significant horizontal branching within each day. The player's accumulated statistics may also unlock or suppress specific choices, creating emergent narrative variation across playthroughs.

---

## 5. Installation & Deployment

### 5.1 Prerequisites

- **Java Development Kit (JDK):** Version 11 or newer (JavaFX is included in JDK 8–10; for JDK 11+, ensure JavaFX libraries are configured in the module path)
- **Integrated Development Environment (IDE):** IntelliJ IDEA, Eclipse, or Visual Studio Code with Java extensions

### 5.2 Build & Run Instructions

1. **Clone or extract** the project directory to your local filesystem.
2. **Open** the project root folder in your preferred IDE.
3. **Locate the main entry point:** `Main.java` (or `App.java`, depending on the build configuration).
4. **Configure the run configuration:**
   - Ensure the JDK is set to 11 or higher.
   - If using a modular JDK (11+), add JavaFX modules to the VM options:
     ```
     --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml
     ```
5. **Execute** the main class to launch the application.

---

## 6. Future Development & Extensibility

The current architecture supports the following extensions without structural refactoring:

- **Additional Endings:** New terminal states can be added by expanding the condition matrix in `StoryData`.
- **Modular Content Packs:** External narrative files (JSON/XML) could replace the hardcoded `HashMap` structure, enabling user-generated content.
- **Save/Load System:** `GameState` is serializable; implementing `Serializable` or JSON export would enable persistence.
- **Enhanced UI:** The JavaFX frontend can be extended with CSS styling, animation libraries, or media integration.
- **Difficulty Modes:** Stat modifier magnitudes can be parameterized to create Easy/Normal/Hard variants.

---

## 7. Academic Context

This project was developed as the final deliverable for **COMP 127** at [Institution Name]. It demonstrates competency in:

- Object-oriented programming (inheritance, encapsulation, polymorphism)
- Event-driven programming and GUI development
- Data structure selection and algorithm design
- Software engineering documentation and version control

---

## 8. Credits & Attribution

| Role | Contributor |
|------|-------------|
| Game Design & Narrative | Ruolin Shen |
| Software Engineering | Tianqi Zhao |
| UI/UX Implementation | Bridgette Mi |

**Course:** COMP 127 Final Project  
**License:** All rights reserved by the authors. This software was created for educational purposes. Unauthorized commercial distribution or public deployment is prohibited without express written consent.

---

*Document Version: 1.0*  
*Last Updated: May 2026*