package tests.marco.syntax
import helpers.MarcoSpecification

class Docstrings extends MarcoSpecification {
    def "for a number"() {
        given:
        eval(/ (def :n @"the first number" 1) /)

        expect:
        eval(/ (doc n) /) == eval(/ "the first number" /)
    }

    def "for a function"() {
        given:
        eval(/ (def :f @"a function" (function [] {})) /)

        expect:
        eval(/ (doc f) /) == eval(/ "a function" /)
    }

    def "copying a docstring when binding"() {
        given:
        eval(/ (def :f @"a function" (function [] {})) /)

        when:
        eval(/ (def :g f) /)

        then:
        eval(/ (doc g) /) == eval(/ "a function" /)
    }
}
