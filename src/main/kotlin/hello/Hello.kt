package hello

data class Person(val firstName: String, val lastName: String)

val lazy: String by lazy {
    "foo" + "bar"
}

fun main(args: Array<String>) {
    val person = Person("Hans", "Wurst")
    println("Hello " + person)
    println(lazy)
}
