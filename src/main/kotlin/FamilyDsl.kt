fun partnership(
        person1: Person,
        person2: Person,
        block: Partnership.() -> Unit = {}
): Partnership {
    val partnership = Partnership(person1, person2)
    partnership.block()
    return partnership
}

data class Partnership(
        val parent1: Person,
        val parent2: Person,
        val children: MutableSet<Family> = mutableSetOf()
) {
    fun child(
            firstName: String,
            lastName: String,
            birthYear: Int? = null,
            alias: String? = null,
            block: Family.() -> Unit = {}
    ): Family {
        val child = FamilyMember(firstName, lastName, birthYear, alias)

        val childFamily = Family(child)
        childFamily.block()
        children += childFamily

        return childFamily
    }
}

fun family(
        firstName: String,
        lastName: String,
        birthYear: Int,
        block: Family.() -> Unit = {}
): Family {
    val family = Family(
            FamilyMember(firstName, lastName, birthYear)
    )
    family.block()
    return family
}

data class Family(
        val self: FamilyMember,
        val partnerships: MutableList<Partnership> = mutableListOf()
) {
    fun partner(
            firstName: String,
            lastName: String,
            birthYear: Int? = null,
            alias: String? = null,
            block: Partnership.() -> Unit = {}
    ): Partnership {
        val partner = FamilyMember(firstName, lastName, birthYear, alias)

        val partnership = Partnership(self, partner)
        partnership.block()
        partnerships += partnership

        return partnership
    }
}

sealed class Person {
    abstract val name: String
}

object Unidentified : Person() {
    override val name: String = "Unidentified"
}

data class FamilyMember(
        val firstName: String,
        val lastName: String,
        val birthYear: Int? = null,
        val alias: String? = null
) : Person() {
    override val name: String = "$firstName $lastName"
}
