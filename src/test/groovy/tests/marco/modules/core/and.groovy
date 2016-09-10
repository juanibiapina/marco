package tests.marco.modules.core

import helpers.MarcoSpecification

class and extends MarcoSpecification {
    def "simple cases"() {
        expect:
        eval(/ (and { 4 } { false }) /) == eval(/ false /)
        eval(/ (and { true } { false }) /) == eval(/ false /)
        eval(/ (and { true } { true }) /) == eval(/ true /)
        eval(/ (and { true } { 4 }) /) == eval(/ 4 /)
    }
}
