# Kordmand

[![Kordmand](https://img.shields.io/badge/Kordmand-1.0.2_SNAPSHOT-blue.svg)]()
<br><br>
[![Java](https://img.shields.io/badge/Java-17-FF7700.svg?logo=java)]()
[![Kotlin](https://img.shields.io/badge/Kotlin-1.6.0-186FCC.svg?logo=kotlin)]()
[![PaperMC](https://img.shields.io/badge/PaperMC-1.18-222222.svg)]()


<br>
<br>


### Use API


## Maven
```xml
<repositories>
    <repository>
        <id>project-central</id>
        <url>https://repo.projecttl.net/repository/maven-public/</url>
    </repository>
</repositories>

<dependency>
    <groupId>kr.blugon</groupId>
    <artifactId>Kordmand</artifactId>
    <version>VERSION</version>
</dependency>
```


## Groovy
```gradle
repositories {
    maven { 'https://repo.projecttl.net/repository/maven-public/' }
}

dependencies {
    implementation 'kr.blugon:Kordmand:VERSION'
}
```

## Kotlin DSL
```gradle
repositories {
    maven("https://repo.projecttl.net/repository/maven-public/")
}

dependencies {
    implementation("kr.blugon:Kordmand:VERSION")
}
```
