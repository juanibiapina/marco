package tests.marco.modules.list

import helpers.MarcoSpecification

class reverse extends MarcoSpecification {
    def "empty list"() {
        expect:
        eval(/ (reverse []) /) == eval(/ [] /)
    }

    def "list with elements"() {
        expect:
        eval(/ (reverse [1 2 3 4]) /) == eval(/ [4 3 2 1] /)
    }
}
