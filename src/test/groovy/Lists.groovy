import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Lists extends MarcoSpecification {
    def "first works for lists"() {
        expect:
        eval(/ (first (quote (1 2))) /) == new MarcoNumber(1)
    }

    def "second works for lists"() {
        expect:
        eval(/ (first (second (quote (1 2 3)))) /) == new MarcoNumber(2)
    }

    def "list-max"() {
        expect:
        eval(/ (list-max '(5 4 3 2 1)) /) == eval(/ 5 /)
        eval(/ (list-max '(1 2 3 4)) /) == eval(/ 4 /)
        eval(/ (list-max '(2 4 1 3)) /) == eval(/ 4 /)
    }

    def "range"() {
        expect:
        eval(/ (range 1 10) /) == eval(/ '(1 2 3 4 5 6 7 8 9) /)
    }

    def "literal lists"() {
        expect:
        eval(/ [] /) == eval(/ nil /)
        eval(/ [1 2 3] /) == eval(/ (cons 1 (cons 2 (cons 3 nil))) /)
    }
}
