package tests.marco.syntax

import helpers.MarcoSpecification
import spock.lang.Ignore

@Ignore
class Docstring extends MarcoSpecification {
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
}
