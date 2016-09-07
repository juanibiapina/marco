package tests.marco.modules.list

import helpers.MarcoSpecification

class any extends MarcoSpecification{
    def "empty list"() {
        expect:
        eval(/ (any even? []) /) == eval(/ false /)
    }

    def "no match"() {
        expect:
        eval(/ (any even? [1 3 5 7 9]) /) == eval(/ false /)
    }

    def "head match"() {
        expect:
        eval(/ (any even? [2 1 3 5 7]) /) == eval(/ true /)
    }

    def "tail match"() {
        expect:
        eval(/ (any even? [1 3 5 7 2]) /) == eval(/ true /)
    }
}
