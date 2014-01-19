import helpers.MarcoSpecification
import marco.lang.MarcoBoolean
import marco.lang.MarcoNumber
import marco.lang.MarcoPair

class Pairs extends MarcoSpecification {
    def "creating a pair"() {
        expect:
        eval(/ (cons 1 2) /) == new MarcoPair(new MarcoNumber(1), new MarcoNumber(2))
    }

    def "first"() {
        expect:
        eval(/ (first (cons true "value")) /) == MarcoBoolean.TRUE
    }

    def "second"() {
        expect:
        eval(/ (second (cons (cons 1 2) 42)) /) == new MarcoNumber(42)
    }

    def "pair?"() {
        expect:
        eval(/ (pair? 1) /) == MarcoBoolean.FALSE
        eval(/ (pair? (cons 1 2)) /) == MarcoBoolean.TRUE
        eval(/ (pair? (cons (cons 1 2) (cons nil nil))) /) == MarcoBoolean.TRUE
        eval(/ (pair? (cons 1 nil)) /) == MarcoBoolean.TRUE
    }

    def "evaluate to themselves"() {
        expect:
        eval(/ (eval (cons 1 2)) /) == eval(/ (cons 1 2) /)
    }
}
