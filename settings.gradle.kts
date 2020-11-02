rootProject.name = "spring-kafka-gradle-sample"

pluginManagement {
    repositories {
        gradlePluginPortal()
        jcenter()
        maven ("https://dl.bintray.com/gradle/gradle-plugins")
        maven ("http://packages.confluent.io/maven/")
        maven ("https://plugins.gradle.org/m2/")
        maven ("https://jitpack.io")
    }
}