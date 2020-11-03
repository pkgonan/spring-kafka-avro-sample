plugins {
    id("org.springframework.boot") version "2.3.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.spring") version "1.4.10"
    id("com.github.imflog.kafka-schema-registry-gradle-plugin") version "1.0.1"
    id("com.commercehub.gradle.plugin.avro") version "0.21.0"
}

group = "io.pkgonan"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven ("http://packages.confluent.io/maven/")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    implementation("org.springframework.kafka:spring-kafka:2.6.2")
    implementation("org.apache.avro:avro:1.10.0")
    implementation("io.confluent:kafka-avro-serializer:5.5.1")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.11.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.11.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.11.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

schemaRegistry {
    // Fixme : Change URL
    url.set("http://localhost:8081")

    download {
        // Fixme : Change Topic
        subject("test-topic-key", "src/main/avro")
        subject("test-topic-value", "src/main/avro")
    }
}

avro {
    isCreateSetters.set(false)
    fieldVisibility.set("PRIVATE")
    outputCharacterEncoding.set("UTF-8")
}

val downloadSchema = tasks.withType<com.github.imflog.schema.registry.download.DownloadTask> {
}

val generateAvroJava = tasks.withType<com.commercehub.gradle.plugin.avro.GenerateAvroJavaTask> {
    dependsOn(downloadSchema)
}