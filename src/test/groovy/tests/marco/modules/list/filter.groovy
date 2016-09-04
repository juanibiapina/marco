package tests.marco.modules.list

import helpers.MarcoSpecification

class filter extends MarcoSpecification {
    def "empty list"() {
        expect:
        eval(/ (filter identity []) /) == eval(/ [] /)
    }

    def "all elements included"() {
        expect:
        eval(/ (filter identity [1 2 3 4]) /) == eval(/ [1 2 3 4] /)
    }

    def "all elements filtered out"() {
        expect:
        eval(/ (filter identity [false false false false false]) /) == eval(/ [] /)
    }

    def "some elements filtered out"() {
        expect:
        eval(/ (filter identity [false 1 false 3 false 5]) /) == eval(/ [1 3 5] /)
    }
}
