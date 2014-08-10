package tests.marco.modules.core

import helpers.MarcoSpecification

class any extends MarcoSpecification{
    def "empty list"() {
        expect:
        eval(/ (any nil even?) /) == eval(/ false /)
    }

    def "no match"() {
        expect:
        eval(/ (any [1 3 5 7 9] even?) /) == eval(/ false /)
    }

    def "head match"() {
        expect:
        eval(/ (any [2 1 3 5 7] even?) /) == eval(/ true /)
    }

    def "tail match"() {
        expect:
        eval(/ (any [1 3 5 7 2] even?) /) == eval(/ true /)
    }
}
