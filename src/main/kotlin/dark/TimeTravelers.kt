package dark

import Family
import FamilyMember
import Partnership
import Person

fun List<Family>.findTimeTravelers(): Set<String> =
    flatMap { family ->
        family.findTimeTravelers()
    }.toSet()

private fun Family.findTimeTravelers(): Set<String> =
    partnerships.flatMap(::timeTravelers).toSet()

private fun timeTravelers(partnership: Partnership): Set<String> {
    val timeTravelers = mutableSetOf<String>()
    val (parent1, parent2, children) = partnership

    if (parent1.isFromDifferentTimePeriod(parent2, children)) {
        timeTravelers.add(parent1.name)
    }
    if (parent2.isFromDifferentTimePeriod(parent1, children)) {
        timeTravelers.add(parent2.name)
    }

    children.forEach {
        val child = it.self
        if (child.bornBefore(parent1)) {
            timeTravelers.add(parent1.name)
        }
        if (child.bornBefore(parent2)) {
            timeTravelers.add(parent2.name)
        }

        timeTravelers.addAll(it.findTimeTravelers())
    }

    return timeTravelers
}

private fun FamilyMember.bornBefore(person: Person): Boolean {
    val familyMember = person as? FamilyMember
    return birthYear != null && familyMember?.birthYear != null && birthYear < familyMember.birthYear
}

private fun FamilyMember.moreThan70YearsOlder(familyMember: FamilyMember): Boolean {
    val birthYear1 = birthYear ?: return false
    val birthYear2 = familyMember.birthYear ?: return false
    return birthYear2 - birthYear1 > 70
}

private fun Person.isFromDifferentTimePeriod(person: Person, children: MutableSet<Family>): Boolean {
    val familyMember1 = this as? FamilyMember
    val familyMember2 = person as? FamilyMember

    return when {
        familyMember1?.birthYear == null || familyMember2?.birthYear == null -> false
        familyMember1.birthYear - familyMember2.birthYear > 30 -> true
        children.any { familyMember1.moreThan70YearsOlder(it.self) } -> true
        else -> false
    }
}
