package tests.marco.modules.core

import helpers.MarcoSpecification

class identity extends MarcoSpecification {
    def "returns the element itself"() {
        expect:
        eval(/ (identity 1) /) == eval(/ 1 /)
        eval(/ (identity "string") /) == eval(/ "string" /)
    }
}
