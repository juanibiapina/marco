package tests.marco.syntax

import helpers.MarcoSpecification

class LiteralList extends MarcoSpecification {
    def "syntax"() {
        expect:
        eval(/ [] /) == eval(/ nil /)
        eval(/ [1 2 3] /) == eval(/ (cons 1 (cons 2 (cons 3 nil))) /)
    }

    def "evaluate their inner elements"() {
        expect:
        eval(/ [1 ((function [] { true }))] /) == eval(/ (cons 1 (cons true nil)) /)
    }
}
