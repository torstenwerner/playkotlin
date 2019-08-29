package hello

data class Person(val firstName: String, val lastName: String)

val lazy: String by lazy {
    "foo" + "bar"
}

fun main() {
    val person = Person(firstName = "Hans", lastName = "Wurst")
    println("Hello $person!")

    println(lazy)

    println(null.toString())

    val embeddedMapSample = "map: ${HashMap<String, String>().apply {
        put("firstName", "Hans")
        put("lastName", "Wurst")
    }}"
    println(embeddedMapSample)
}
