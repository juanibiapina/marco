package tests.marco.features

import helpers.MarcoSpecification

class Shadowing extends MarcoSpecification {
    def "def bindings shadow previous bindings"() {
        when:
        eval(/ (def :x 1) /)
        eval(/ (def :x 2) /)

        then:
        eval(/ x /) == eval(/ 2 /)
    }

    def "function parameters shadow previous bindings"() {
        when:
        eval(/ (def :x 1) /)
        eval(/ (def :f (function [:x] {x})) /)

        then:
        eval(/ (f 2) /) == eval(/ 2 /)
    }

    def "functions have access to the binding at the time of its definition (ignore later shadowing)"() {
        when:
        eval(/ (def :x 1) /)
        eval(/ (def :f (function [] {x})) /)
        eval(/ (def :x 2) /)

        then:
        eval(/ (f) /) == eval(/ 1 /)
    }
}
