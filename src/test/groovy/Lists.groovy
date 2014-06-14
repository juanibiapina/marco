import helpers.MarcoSpecification

class Lists extends MarcoSpecification {
    def "head"() {
        expect:
        eval(/ (head [1 2]) /) == eval(/ 1 /)
    }

    def "tail"() {
        expect:
        eval(/ (tail [1 2 3]) /) == eval(/ [2 3] /)
    }

    def "literal lists"() {
        expect:
        eval(/ [] /) == eval(/ nil /)
        eval(/ [1 2 3] /) == eval(/ (cons 1 (cons 2 (cons 3 nil))) /)
    }

    def "literal lists evaluate their inner elements"() {
        expect:
        eval(/ [1 ((function [] { true }))] /) == eval(/ (cons 1 (cons true nil)) /)
    }

    def "constructor"() {
        expect:
        eval(/ (list? [1 2]) /) == eval(/ true /)
        eval(/ (list? (cons 1 nil)) /) == eval(/ true /)
        eval(/ (list? (cons 1 (cons 2 nil))) /) == eval(/ true /)
        eval(/ (list? 1) /) == eval(/ false /)
        eval(/ (list? "string") /) == eval(/ false /)
        eval(/ (list? nil) /) == eval(/ true /)
    }

    def "length"() {
        expect:
        eval(/ (length nil) /) == eval(/ 0 /)
        eval(/ (length []) /) == eval(/ 0 /)
        eval(/ (length ["lol"]) /) == eval(/ 1 /)
        eval(/ (length [1 2 3]) /) == eval(/ 3 /)
        eval(/ (length [1 2 3 "house"]) /) == eval(/ 4 /)
    }

    def "list-max"() {
        expect:
        eval(/ (list-max [5 4 3 2 1]) /) == eval(/ 5 /)
        eval(/ (list-max [1 2 3 4]) /) == eval(/ 4 /)
        eval(/ (list-max [2 4 1 3]) /) == eval(/ 4 /)
    }

    def "range"() {
        expect:
        eval(/ (range 1 10) /) == eval(/ [1 2 3 4 5 6 7 8 9] /)
    }
}
