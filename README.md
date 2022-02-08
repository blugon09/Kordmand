# Kordmand

[![Kordmand](https://img.shields.io/badge/Kordmand-1.0.4_SNAPSHOT-blue.svg)]()
<br><br>
[![Java](https://img.shields.io/badge/Java-11-FF7700.svg?logo=java)]()
[![Kotlin](https://img.shields.io/badge/Kotlin-1.6.10-186FCC.svg?logo=kotlin)]()


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
