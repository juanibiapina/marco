package tests.marco.lang.functions.functions

import helpers.MarcoSpecification

class apply extends MarcoSpecification {
    def "applying a function without arguments"() {
        given:
        eval(/ (def :f (function [] { 1 })) /)

        expect:
        eval(/ (apply f []) /) == eval(/ 1 /)
    }

    def "applying a function to a list of arguments"() {
        expect:
        eval(/ (apply + [1 2]) /) == eval(/ 3 /)
    }
}
