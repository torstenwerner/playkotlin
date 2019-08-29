package hello

fun isValidIdentifier(s: String): Boolean {
    fun Char.isValidFirst() = isLetter() ||  this == '_'
    fun String.hasValidFirstCharacter() = get(0).isValidFirst()
    fun Char.isValidExtraCharacter() = isValidFirst() || isDigit()
    fun String.hasOnlyValidExtraCharacters() = substring(1).all(Char::isValidExtraCharacter)

    return !s.isEmpty() && s.hasValidFirstCharacter() && s.hasOnlyValidExtraCharacters()
}

fun main() {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}
