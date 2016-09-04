package tests.marco.lang.functions.booleans

import helpers.MarcoSpecification

class not extends MarcoSpecification {
    def "not for booleans"() {
        expect:
        eval(/ (not true) /) == eval(/ false /)
        eval(/ (not false) /) == eval(/ true /)
    }

    def "not for numbers"() {
        eval(/ (not 1) /) == eval(/ false /)
    }
}
