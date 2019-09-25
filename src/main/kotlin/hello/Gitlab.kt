package hello

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule

fun main() {

    val configuration = gitlab {
        job("setup") {
            script("npm install")
        }
        job("build") {
            script("./gradlew clean build")
        }
        job("test")
    }

    println(configuration.toYaml())
}

fun gitlab(configLambda: Gitlab.() -> Unit): Gitlab = Gitlab().apply(configLambda)

data class Gitlab(val jobs: MutableMap<String, Job> = mutableMapOf()) {

    fun job(name: String, configLambda: Job.() -> Unit = {}) {
        val job = Job(name).apply(configLambda)
        jobs[name] = job
    }

    fun toYaml(): String = mapper.writeValueAsString(jobs)

    companion object {
        val mapper by lazy {
            ObjectMapper(YAMLFactory())
                    .registerModule(KotlinModule())
                    .setSerializationInclusion(NON_EMPTY)
        }
    }
}

data class Job(@JsonIgnore val name: String, val script: MutableList<String> = mutableListOf()) {

    fun script(script: String) {
        this.script.add(script)
    }
}
