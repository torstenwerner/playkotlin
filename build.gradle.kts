plugins {
    kotlin("jvm") version Constants.kotlinVersion
}

description = "a playground for kotlin"
version = Constants.projectVersion

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${Constants.coroutinesVersion}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${Constants.jacksonVersion}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Constants.jacksonVersion}")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:${Constants.jacksonVersion}")

    testImplementation("org.junit.jupiter:junit-jupiter-api:${Constants.junitVersion}")
    testImplementation("org.assertj:assertj-core:${Constants.assertjVersion}")

    testRuntime("org.junit.jupiter:junit-jupiter-engine:${Constants.junitVersion}")
}

tasks.wrapper {
    gradleVersion = Constants.gradleVersion
    distributionType = Wrapper.DistributionType.ALL
}
