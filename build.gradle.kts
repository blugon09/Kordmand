plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.dokka") version "1.5.0"
    `maven-publish`
}

group = "kr.blugon"
version = "1.0.5-SNAPSHOT"


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}


repositories {
    mavenCentral()
    maven("https://jcenter.bintray.com")
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")

    implementation("dev.kord:kord-core:0.8.0-M8")
    implementation("org.json:json:20190722")

    implementation("org.jsoup:jsoup:1.14.3")
}

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }

    jar {
        archiveVersion.set(project.version.toString())
        archiveBaseName.set(project.name)
        archiveFileName.set("${project.name}-${project.version}-all.jar")
        from(sourceSets["main"].output)
    }

    create<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    create<Jar>("javadocJar") {
        archiveClassifier.set("javadoc")
        dependsOn("dokkaHtml")
        from("$buildDir/dokka/html")
    }
}


publishing {
    publications {
        create<MavenPublication>(rootProject.name) {
            artifact(tasks["jar"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])

            repositories {
                maven {
                    val releasesRepoUrl = "https://repo.projecttl.net/repository/maven-releases/"
                    val snapshotsRepoUrl = "https://repo.projecttl.net/repository/maven-snapshots/"
                    url = uri(
                        if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl
                        else releasesRepoUrl
                    )

                    credentials.runCatching {
                        username = project.properties["username"] as String?
                        password = project.properties["password"] as String?
                    }
                }
            }


            pom {
                name.set(rootProject.name)
                description.set("")
                url.set("https://github.com/blugon09/${rootProject.name}")
                developers {
                    developer {
                        id.set("blugon09")
                        name.set("Blugon")
                        email.set("blugon0921@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/blugon09/${rootProject.name}.git")
                    developerConnection.set("scm:git:https://github.com/blugon09/${rootProject.name}.git")
                    url.set("https://github.com/blugon09/${rootProject.name}.git")
                }
            }
        }
    }
}