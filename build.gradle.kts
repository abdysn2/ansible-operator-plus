plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.21"
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
    }

    testImplementation(kotlin("test"))
}

//
//intellijPlatform {
//    pluginVerification {
//        ides {
//            // Option A: simplest - let the plugin pick a sensible set based on your build range
//            //recommended()
//
//            // Option B: explicitly list IDEs (uncomment if you prefer explicit control)
//             ide("IC", "2025.1") // IntelliJ IDEA Community
//            // ide("IU", "2025.1") // IntelliJ IDEA Ultimate
//            // ide("PY", "2025.1") // PyCharm (if you want to verify there too)
//            // ide("GO", "2025.1") // GoLand
//
//        }
//    }
//}

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
        jvmArgs("-Xmx8g")
    }
}

tasks.test { // See 4️⃣
    useJUnitPlatform() // JUnitPlatform for tests. See 5️⃣
}
