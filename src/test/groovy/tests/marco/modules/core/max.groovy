package tests.marco.modules.core

import helpers.MarcoSpecification

class max extends MarcoSpecification {
    def "simple test"() {
        expect:
        eval(/ (max 1 2) /) == eval(/ 2 /)
        eval(/ (max 3 2) /) == eval(/ 3 /)
        eval(/ (max 3 3) /) == eval(/ 3 /)
    }
}
