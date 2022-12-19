package devops

data class Person(val name: String, val surname: String)

fun main(args: Array<String>) {
    val p = Person("Andrea", "Giulianelli")
    println("Hello World from ${p.name}${p.surname}!")
}