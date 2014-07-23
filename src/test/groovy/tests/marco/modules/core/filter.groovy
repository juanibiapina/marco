package tests.marco.modules.core

import helpers.MarcoSpecification

class filter extends MarcoSpecification {
    def "empty list"() {
        given:
        eval(/ (def :f (function [:e] { e })) /)

        expect:
        eval(/ (filter [] f) /) == eval(/ [] /)
    }

    def "all elements included"() {
        given:
        eval(/ (def :f (function [:e] { e })) /)

        expect:
        eval(/ (filter [1 2 3 4] f) /) == eval(/ [1 2 3 4] /)
    }

    def "all elements filtered out"() {
        given:
        eval(/ (def :f (function [:e] { e })) /)

        expect:
        eval(/ (filter [false false false false false] f) /) == eval(/ [] /)
    }

    def "some elements filtered out"() {
        given:
        eval(/ (def :f (function [:e] { e })) /)

        expect:
        eval(/ (filter [false 1 false 3 false 5] f) /) == eval(/ [1 3 5] /)
    }
}
