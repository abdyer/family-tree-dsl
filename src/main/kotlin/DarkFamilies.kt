// Source: https://dark.netflix.io
object DarkFamilies {

    val nielsenFamily = family("Agnes", "Nielsen", 1910) {
        partner("The", "Unknown") {
            child("Tronte", "Nielsen", 1941) {
                partner("Jana", "Nielsen", 1942) {
                    child("Ulrich", "Nielsen", 1971) {
                        partner("Katarina", "Nielsen", 1970) {
                            child("Magnus", "Nielsen", 2001)
                            child("Martha", "Nielsen", 2003, "Eva")
                            child("Mikkel", "Nielsen", 2008, "Michael Kahnwald") {
                                partner("Hannah", "Kahnwald", 1972) {
                                    child("Jonas", "Kahnwald", 2003, "Adam") {
                                        partner("Martha", "Nielsen", 2003) {
                                            child("The", "Unknown")
                                        }
                                    }
                                }
                            }
                        }

                        partner("Hannah", "Kahnwald", 1972)
                    }
                    child("Mads", "Nielsen", 1974)
                }

                partner("Claudia", "Tiedemann", 1942)
            }
        }
    }

    val tiedemannFamily = family("Egon", "Tiedemann", 1922) {
        partner("Doris", "Tiedemann", 1922) {
            child("Claudia", "Tiedemann", 1942) {
                partner("Bernd", "Doppler", 1913) {
                    child("Regina", "Tiedemann", 1971) {
                        partner("Aleksander", "Tiedemann", 1966, "Boris Niewald") {
                            child("Bartosz", "Tiedemann", 2003)
                        }
                    }
                }
            }
        }

        partner("Hannah", "Kahnwald", 1972) {
            child("Silja", "Tiedemann", 1988) {
                partner("Bartosz", "Tiedemann", 2003) {
                    child("Noah", "Tiedemann", 1904, "Hanno Tauber")
                    child("Agnes", "Tiedemann", 1910)
                }
            }
        }
    }

    val dopplerFamily = family("Bernd", "Doppler", 1913) {
        partner("Greta", "Doppler", 1917) {
            child("Helge", "Doppler", 1944) {
                partner("Ulla", "Schmidt") {
                    child("Peter", "Doppler", 1970) {
                        partner("Charlotte", "Doppler", 1971) {
                            child("Franziska", "Doppler", 2003)
                            child("Elisabeth", "Doppler", 2011) {
                                partner("Noah", "Tiedemann", 1904) {
                                    child("Charlotte", "Doppler", 2041)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    val kahnwaldFamily = family("Daniel", "Kahnwald", 1915) {
        partner(Unidentified) {
            child("Ines", "Kahnwald", 1940)
        }
    }

    val obendorfFamily = family("Jürgen", "Obendorf", 1971) {
        partner(Unidentified) {
            child("Kilian", "Obendorf", 2003)
            child("Erik", "Obendorf", 2004)
        }
    }

    val tannhausFamily = family("Heinrich", "Tannhaus") {
        partner(Unidentified) {
            child("Gustav", "Tannhaus", 1813) {
                partner(Unidentified) {
                    child("Leopold", "Tannhaus") {
                        partner(Unidentified) {
                            child("H. G.", "Tannhaus", 1913)
                        }
                    }
                }
            }
        }
    }
}
