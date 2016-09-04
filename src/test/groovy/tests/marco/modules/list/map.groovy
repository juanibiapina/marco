package tests.marco.modules.list

import helpers.MarcoSpecification

class map extends MarcoSpecification {
    def "empty list"() {
        expect:
        eval(/ (map identity []) /) == eval(/ [] /)
    }

    def "one element"() {
        given:
        eval(/ (def :f (function [:e] { (+ e 1) })) /)

        expect:
        eval(/ (map f [1]) /) == eval(/ [2] /)
    }

    def "several elements"() {
        given:
        eval(/ (def :f (function [:e] { (+ e 1) })) /)

        expect:
        eval(/ (map f [1 2 3 4 5]) /) == eval(/ [2 3 4 5 6] /)
    }
}
