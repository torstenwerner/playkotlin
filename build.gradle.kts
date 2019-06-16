plugins {
    kotlin("jvm") version "1.3.31"
}

description = "a playground for kotlin"
version = "0.2"

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
}

tasks.wrapper {
    gradleVersion = "5.4.1"
    distributionType = Wrapper.DistributionType.ALL
}
