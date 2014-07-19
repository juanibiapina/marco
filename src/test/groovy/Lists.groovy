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
}
