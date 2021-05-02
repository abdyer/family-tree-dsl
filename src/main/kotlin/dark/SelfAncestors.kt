package dark

import Family
import Partnership

fun List<Family>.findSelfAncestors(): Set<String> =
    flatMap {
        val result = it.partnerships.fold(SelfAncestorsResult(), ::findSelfAncestors)
        result.selfAncestors
    }.toSet()

private fun findSelfAncestors(
    initial: SelfAncestorsResult = SelfAncestorsResult(),
    partnership: Partnership
): SelfAncestorsResult {
    val (parent1, parent2, children) = partnership

    initial.ancestors.add(parent1.name)
    initial.ancestors.add(parent2.name)

    return children.fold(initial) { result, family ->
        val name = family.self.name
        if (result.ancestors.any { it == name }) {
            result.selfAncestors.add(name)
        }

        family.partnerships.fold(result, ::findSelfAncestors)
    }
}

private data class SelfAncestorsResult(
    val ancestors: MutableSet<String> = mutableSetOf(),
    val selfAncestors: MutableSet<String> = mutableSetOf()
)
