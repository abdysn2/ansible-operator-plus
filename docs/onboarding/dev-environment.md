# Development Environment (Dev Setup)

This repository is an **IntelliJ Platform plugin** (Kotlin + Gradle) targeting **IntelliJ IDEA Community 2025.1** and **Java 17**.

This guide covers:
- Prerequisites
- Creating a new plugin project (same approach used for this repo)
- Cloning + setting up this project locally
- Common Gradle tasks for development and CI parity

---

## Prerequisites

### Required
- **JDK 17** (Temurin recommended)
- **Git**
- **IntelliJ IDEA 2025.x** (Community is fine)
- Internet access (Gradle will download the IntelliJ Platform SDK and dependencies)

### Recommended
- 16+ GB RAM (running a nested IDE instance is memory-hungry)

---

## Create a new project (DevKit / Plugin template approach)

If you want to create a fresh plugin project with a correct baseline structure:

1. **Install IntelliJ IDEA (2025.x)**.
2. Open IntelliJ IDEA → **New Project**.
3. Choose **IntelliJ Platform Plugin** (or “Plugin” template depending on IDE UI wording).
4. Configure:
    - **Language**: Kotlin
    - **Build system**: Gradle (Kotlin DSL)
    - **JDK**: 17
5. Create the project and let Gradle sync.
6. In the generated project:
    - Ensure you can run the plugin sandbox IDE (see “Run the IDE (sandbox)” below).
    - Ensure CI-friendly tasks exist (see “Useful Gradle tasks”).

This repository follows that “generated structure first, then iterate” workflow.

---

## Set up this repository locally

### 1) Clone
```bash
git clone <REPO_URL> cd ansible-operator-plus
```

### 2) Ensure Java 17 is used

You have two good options—pick **one**:

#### Option A (recommended): Set `JAVA_HOME`
Set `JAVA_HOME` to your JDK 17 installation and ensure `java -version` reports 17.

- Windows (PowerShell):
```powershell
setx JAVA_HOME "C:\Path\To\JDK17"
```
Then open a new terminal and verify:
```bash
java -version
```
#### Option B: Point Gradle to a local JDK via `gradle.properties`
This repo supports configuring Gradle’s JDK explicitly.

In `gradle.properties`, set:
```properties
org.gradle.java.home=<ABSOLUTE_PATH_TO_YOUR_JDK_17>
```
Use a **machine-local path** (do not commit personal paths). Example placeholder:
- Windows: `C:\\Tools\\Java\\temurin-17`
- macOS/Linux: `/opt/jdk/temurin-17`

> Note: The project also uses the Gradle toolchain mechanism (Java toolchain set to 17). The simplest and most portable setup is still `JAVA_HOME` + toolchains.

### 3) Import in IntelliJ IDEA
1. IntelliJ IDEA → **Open** → select the repository folder.
2. When prompted:
    - Trust the project
    - Import as **Gradle** project
3. Wait for Gradle sync to finish (first import will take longer).

---

## Running and verifying

All commands below should be run from the project root using the Gradle wrapper.

### Run the IDE (sandbox)
This launches a sandbox IntelliJ instance with your plugin installed:
```bash
./gradlew runIde
```
If you run out of memory, increase IDE heap for the sandbox run (already set to a higher value in the Gradle config).

### Build the plugin artifact (matches CI)
CI builds using:
```bash
./gradlew buildPlugin --no-daemon
```
The output plugin ZIP is typically produced under a Gradle build output directory.

### Verify plugin structure (matches CI)
There is a CI workflow that runs:
```bash
./gradlew verifyPluginStructure --no-daemon
```
Run this locally before opening a PR.

### Run tests
```bash
./gradlew test
```
---

## Useful Gradle tasks (quick list)
```bash
./gradlew tasks
```
Common ones for plugin development:
- `runIde` — run sandbox IDE with plugin
- `buildPlugin` — build distributable plugin
- `verifyPluginStructure` — validate plugin layout/metadata expectations
- `test` — run unit tests

---

## Notes / Gotchas

- **JDK version matters**: use Java 17 consistently for Gradle + compilation.
- **First build is slow**: Gradle will download the IntelliJ Platform dependencies.
- **Optional integrations**: Some features may depend on additional IDE capabilities (e.g., Python support). The plugin should still load in IntelliJ IDEA Community without them.
- **Do not commit machine-local paths**: anything like `org.gradle.java.home` should remain personal/local.

---

## Troubleshooting

### Gradle can’t find Java / wrong Java version
- Check:
  ```bash
  java -version
  ```
- Ensure `JAVA_HOME` points to JDK 17 (not a JRE, not JDK 21).
- If using `org.gradle.java.home`, ensure the path exists and is readable.

### `runIde` is slow or crashes
- Close other heavy apps.
- Increase available RAM.
- Re-run with a clean build if needed:
  ```bash
  ./gradlew clean runIde
  ```
---