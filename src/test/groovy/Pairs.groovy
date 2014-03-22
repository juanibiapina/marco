import helpers.MarcoSpecification
import marco.lang.MarcoNumber
import marco.lang.MarcoPair

class Pairs extends MarcoSpecification {
    def "creating a pair"() {
        expect:
        eval(/ (cons 1 2) /) == new MarcoPair(new MarcoNumber(1), new MarcoNumber(2))
    }

    def "first"() {
        expect:
        eval(/ (first (cons true "value")) /) == eval(/ true /)
    }

    def "second"() {
        expect:
        eval(/ (second (cons (cons 1 2) 42)) /) == new MarcoNumber(42)
    }

    def "pair?"() {
        expect:
        eval(/ (pair? 1) /) == eval(/ false /)
        eval(/ (pair? (cons 1 2)) /) == eval(/ true /)
        eval(/ (pair? (cons (cons 1 2) (cons nil nil))) /) == eval(/ true /)
        eval(/ (pair? (cons 1 nil)) /) == eval(/ true /)
    }
}
