import dark.DarkFamilies
import dark.findSelfAncestors
import dark.findTimeTravelers

fun main(args: Array<String>) {
    println(simpsonFamily)
    println()

    val darkFamilies = DarkFamilies.allFamilies

    darkFamilies.forEach(::println)
    println()

    // Where did time travel occur?
    println("Time Travelers:")
    darkFamilies.findTimeTravelers().forEach(::println)
    println()

    // Who is their own great/grand/parent?
    println("Self Ancestors:")
    darkFamilies.findSelfAncestors().forEach(::println)
}
