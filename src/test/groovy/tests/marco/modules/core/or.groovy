package tests.marco.modules.core

import helpers.MarcoSpecification

class or extends MarcoSpecification {
    def "simple cases"() {
        expect:
        eval(/ (or { 4 } { false }) /) == eval(/ 4 /)
        eval(/ (or { true } { false }) /) == eval(/ true /)
        eval(/ (or { false } { 4 }) /) == eval(/ 4 /)
    }

    def "lazy evaluation"() {
        expect:
        eval(/ (or { true } { (error) }) /) == eval(/ true /)
    }

    def "access to lexical scope"() {
        given:
        eval(/ (def :b 1) /)

        expect:
        eval(/ (or { b } { (error) }) /) == eval(/ 1 /)
    }
}
