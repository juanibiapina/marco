package tests.marco.lang.functions.block

import helpers.MarcoSpecification

class invoke extends MarcoSpecification {
    def "returns the last value of the block"() {
        given:
        eval(/ (def :program { (def :b 1) b } ) /)

        expect:
        eval(/ (invoke program) /) == eval(/ 1 /)
    }
}
