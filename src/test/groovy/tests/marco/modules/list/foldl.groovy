package tests.marco.modules.list

import helpers.MarcoSpecification

class foldl extends MarcoSpecification {
    def "with an empty list returns the initial element"() {
        expect:
        eval(/ (foldl - 42 []) /) == eval(/ 42 /)
    }

    def "with an non empty list, applies the fold logic"() {
        expect:
        eval(/ (foldl - 1 [1 4]) /) == eval(/ -4 /)
    }
}
