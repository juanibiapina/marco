package tests.marco.lang.functions.pairs
import helpers.MarcoSpecification

class pair extends MarcoSpecification {
    def "creating pairs"() {
        expect:
        eval(/ (first (pair 1 2)) /) == eval(/ 1 /)
        eval(/ (second (pair 1 2)) /) == eval(/ 2 /)
    }

    def "pair type"() {
        expect:
        eval(/ (pair? (pair 1 2)) /) == eval(/ true /)
        eval(/ (pair? 1) /) == eval(/ false /)
    }
}
