package tests.marco.lang.functions.pair
import helpers.MarcoSpecification

class pair extends MarcoSpecification {
    def "creating pairs"() {
        expect:
        eval(/ (first (pair 1 2)) /) == eval(/ 1 /)
        eval(/ (second (pair 1 2)) /) == eval(/ 2 /)
    }
}
