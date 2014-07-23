package tests.marco.modules.core

import helpers.MarcoSpecification

class map extends MarcoSpecification {
    def "empty list"() {
        given:
        eval(/ (def :f (function [:e] { (+ e 1) })) /)

        expect:
        eval(/ (map [] f) /) == eval(/ [] /)
    }

    def "one element"() {
        given:
        eval(/ (def :f (function [:e] { (+ e 1) })) /)

        expect:
        eval(/ (map [1] f) /) == eval(/ [2] /)
    }

    def "several elements"() {
        given:
        eval(/ (def :f (function [:e] { (+ e 1) })) /)

        expect:
        eval(/ (map [1 2 3 4 5] f) /) == eval(/ [2 3 4 5 6] /)
    }
}
