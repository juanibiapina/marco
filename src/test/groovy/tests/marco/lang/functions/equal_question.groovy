package tests.marco.lang.functions

import helpers.MarcoSpecification

class equal_question extends MarcoSpecification {
    def "numbers"() {
        expect:
        eval(/ (equal? 1 2) /) == eval(/ false /)
        eval(/ (equal? 1 1) /) == eval(/ true /)
    }
}
