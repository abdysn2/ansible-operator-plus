plugins {
    kotlin("jvm") version "2.0.21"
    id("org.jetbrains.intellij.platform") version "2.10.5"
}

group = "io.github.abdysn2"
version = "0.1.0"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        // Target IntelliJ IDEA Community (IC) 2025.1
        // Docs use intellijIdea("...") as the dependency helper.
        intellijIdea("2025.1")

        // Bundled plugin dependency (YAML)
        bundledPlugin("org.jetbrains.plugins.yaml")
        // or: bundledPlugin("com.intellij.yaml") depending on your target IDE build;
        // see below note.
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks {
    patchPluginXml {
        sinceBuild.set("242")
        untilBuild.set("251.*")
    }

    buildSearchableOptions {
        enabled = false
    }

    runIde {
        jvmArgs("-Xmx2g")
    }
}
