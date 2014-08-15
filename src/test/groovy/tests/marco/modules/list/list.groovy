package tests.marco.modules.list

import helpers.MarcoSpecification

class list extends MarcoSpecification {
    def "head"() {
        expect:
        eval(/ (head [1 2]) /) == eval(/ 1 /)
    }

    def "tail"() {
        expect:
        eval(/ (tail [1 2 3]) /) == eval(/ [2 3] /)
    }

    def "length"() {
        expect:
        eval(/ (length nil) /) == eval(/ 0 /)
        eval(/ (length []) /) == eval(/ 0 /)
        eval(/ (length ["lol"]) /) == eval(/ 1 /)
        eval(/ (length ["lol" 1]) /) == eval(/ 2 /)
        eval(/ (length [1 2 3]) /) == eval(/ 3 /)
        eval(/ (length [1 2 3 "house"]) /) == eval(/ 4 /)
    }

    def "type"() {
        expect:
        eval(/ (list? [1 2]) /) == eval(/ true /)
        eval(/ (list? (cons 1 nil)) /) == eval(/ true /)
        eval(/ (list? (cons 1 (cons 2 nil))) /) == eval(/ true /)
        eval(/ (list? 1) /) == eval(/ false /)
        eval(/ (list? "string") /) == eval(/ false /)
        eval(/ (list? nil) /) == eval(/ true /)
    }
}
