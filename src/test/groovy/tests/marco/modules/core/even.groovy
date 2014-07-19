package tests.marco.modules.core

import helpers.MarcoSpecification

class even extends MarcoSpecification {
    def "even?"() {
        expect:
        eval(/ (even? 0) /) == eval(/ true /)
        eval(/ (even? 1) /) == eval(/ false /)
        eval(/ (even? 2) /) == eval(/ true /)
    }
}
