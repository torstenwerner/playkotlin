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
}

tasks.wrapper {
    gradleVersion = Constants.gradleVersion
    distributionType = Wrapper.DistributionType.ALL
}
