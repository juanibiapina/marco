package tests.marco.lang.functions.blocks

import helpers.MarcoSpecification

class invoke extends MarcoSpecification {
    def "returns the last value of the block"() {
        given:
        eval(/ (def :block { (def :a 1) (def :b a) b } ) /)

        expect:
        eval(/ (invoke block) /) == eval(/ 1 /)
    }

    def "access to lexical scope"() {
        given:
        eval(/ (def :b 1) /)

        expect:
        eval(/ (invoke { b }) /) == eval(/ 1 /)
    }
}
