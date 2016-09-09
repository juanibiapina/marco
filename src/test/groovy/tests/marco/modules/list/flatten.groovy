package tests.marco.modules.list

import helpers.MarcoSpecification

class flatten extends MarcoSpecification {
    def "empty list"() {
        expect:
        eval(/ (flatten []) /) == eval(/ [] /)
    }

    def "list without nesting"() {
        expect:
        eval(/ (flatten [1 2 3 4]) /) == eval(/ [1 2 3 4] /)
    }

    def "one level of nesting"() {
        expect:
        eval(/ (flatten [1 [2 3] 4 5]) /) == eval(/ [1 2 3 4 5] /)
    }

    def "one level of nesting twice"() {
        expect:
        eval(/ (flatten [1 [2 3] 4 [5 6 7]]) /) == eval(/ [1 2 3 4 5 6 7] /)
    }

    def "two levels of nesting"() {
        expect:
        eval(/ (flatten [1 [[2 3]] 4 5]) /) == eval(/ [1 2 3 4 5] /)
    }

    def "mixed levels of nesting"() {
        expect:
        eval(/ (flatten [1 [[2 [3 4]]] [[[[[[[5]]]]]]] 6]) /) == eval(/ [1 2 3 4 5 6] /)
    }
}
