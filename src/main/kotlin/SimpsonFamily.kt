// Source: https://simpsons.fandom.com/wiki/Simpson_family
val simpsonFamily = family("Abraham", "Simpson") {
    partner("Mona", "Simpson") {
        child("Homer", "Simpson") {
            partner("Marge", "Bouvier") {
                child("Bart", "Simpson")
                child("Lisa", "Simpson")
                child("Maggie", "Simpson")
            }
        }
    }
}
