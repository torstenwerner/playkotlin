package hello

fun isValidIdentifier(s: String): Boolean {
    fun isEmptyString(s: String) = s.length == 0
    fun isValidFirstCharacter(c: Char) = c == '_' || c in 'A'..'z'
    fun hasValidFirstCharacter(s: String) = isValidFirstCharacter(s.get(0))
    fun isValidExtraCharacter(c: Char) = isValidFirstCharacter(c) || c in '0'..'9'
    fun hasOnlyValidExtraCharacters(s: String) = s.substring(1).all { isValidExtraCharacter(it) }

    return !isEmptyString(s) && hasValidFirstCharacter(s) && hasOnlyValidExtraCharacters(s)
}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}
