# Student Society Management System

**A JavaFX-based desktop application (Maven) to manage student societies, events, members and basic interactions.**

---

## Quick overview

This repository contains a Java (Maven) project that implements a Student Society Management System using **JavaFX** for the GUI. The application uses modular Java (`module-info.java`) and depends on **JavaFX 20** (controls + fxml). The project's source code is under the `src/main/java` folder and FXML view(s) are in `src/main/resources`.

---

## Key points

- Project type: **Maven Java project** (`pom.xml`, `mvnw`, `.mvn` wrapper included)
- GUI framework: **JavaFX**
- Main Java source: `src/main/java/com/example/studentsocietymanagementsystem/GUI.java`
- Module declaration: `src/main/java/module-info.java`
- FXML resource: `src/main/resources/com/example/studentsocietymanagementsystem/hello-view.fxml`
- Java source/target: **20**
- JavaFX dependencies: **20.0.1**
- JavaFX Maven plugin configured (`mvn javafx:run` works)

---

## Requirements

- Java JDK **20**
- Maven (or use the included Maven wrapper: `./mvnw` or `mvnw.cmd`)
- Internet connection for initial dependency download

---

## Run the app (via Maven)

Linux/macOS:

```bash
cd StudentSocietyManagementSystem/StudentSocietyManagementSystem
./mvnw clean javafx:run
```

---

## Windows (PowerShell / CMD):

<pre class="overflow-visible!" data-start="1367" data-end="1475"><div class="contain-inline-size rounded-2xl relative bg-token-sidebar-surface-primary"><div class="sticky top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-powershell"><span>cd StudentSocietyManagementSystem\StudentSocietyManagementSystem
mvnw.cmd clean javafx:run</span></code></div></div></pre>

---

## Alternative: build a jar

<pre class="overflow-visible!" data-start="1511" data-end="1691"><div class="contain-inline-size rounded-2xl relative bg-token-sidebar-surface-primary"><div class="sticky top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre! language-bash"><span><span>./mvnw clean package
java --module-path /path/to/javafx-sdk-20/lib --add-modules javafx.controls,javafx.fxml -jar target/StudentSocietyManagementSystem-1.0-SNAPSHOT.jar
</span></span></code></div></div></pre>

---

## Run from an IDE (IntelliJ IDEA recommended)

1. Open IntelliJ IDEA → *Open* → select `StudentSocietyManagementSystem/StudentSocietyManagementSystem`
2. Let Maven import dependencies.
3. Run `GUI.java` (main method) or execute `mvn javafx:run`.

---

## Project structure

<pre class="overflow-visible!" data-start="1973" data-end="2268"><div class="contain-inline-size rounded-2xl relative bg-token-sidebar-surface-primary"><div class="sticky top-9"><div class="absolute end-0 bottom-0 flex h-9 items-center pe-2"><div class="bg-token-bg-elevated-secondary text-token-text-secondary flex items-center gap-4 rounded-sm px-2 font-sans text-xs"></div></div></div><div class="overflow-y-auto p-4" dir="ltr"><code class="whitespace-pre!"><span><span>StudentSocietyManagementSystem/
├─ pom.xml
├─ mvnw, mvnw.cmd, .mvn/
├─ src/
│  ├─ main/
│  │  ├─ java/com/example/.../GUI.java
│  │  ├─ java/module-info.java
│  └─ resources/.../hello-view.fxml
└─ target/classes/...
README.md
</span></span></code></div></div></pre>

---

## License & Author

```
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Author: Muhammad Asad
```
