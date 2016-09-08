package tests.marco.modules.list

import helpers.MarcoSpecification

class append extends MarcoSpecification {
    def "empty lists"() {
        expect:
        eval(/ (append [] []) /) == eval(/ [] /)
    }

    def "first list is empty"() {
        expect:
        eval(/ (append [] [3 4]) /) == eval(/ [3 4] /)
    }

    def "second list is empty"() {
        expect:
        eval(/ (append [1 2] []) /) == eval(/ [1 2] /)
    }

    def "both lists have items"() {
        expect:
        eval(/ (append [1 2] [3 4]) /) == eval(/ [1 2 3 4] /)
    }
}
