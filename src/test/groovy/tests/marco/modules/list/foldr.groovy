package tests.marco.modules.list

import helpers.MarcoSpecification

class foldr extends MarcoSpecification {
    def "with an empty list returns the initial element"() {
        expect:
        eval(/ (foldr - 42 []) /) == eval(/ 42 /)
    }

    def "with an non empty list, it is the identity function"() {
        expect:
        eval(/ (foldr cons [] [1 2 3 4]) /) == eval(/ [1 2 3 4] /)
    }

    def "with an non empty list, applies the fold right logic"() {
        expect:
        eval(/ (foldr - 1 [1 4]) /) == eval(/ -2 /)
    }
}
