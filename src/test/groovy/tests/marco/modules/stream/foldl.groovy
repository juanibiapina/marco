package tests.marco.modules.stream

import helpers.MarcoSpecification

class foldl extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "with an empty stream returns the initial element"() {
        expect:
        eval(/ (stream.foldl - 42 stream.empty) /) == eval(/ 42 /)
    }

    def "with a finite stream, does the left fold"() {
        expect:
        eval(/ (stream.foldl - 1 (stream.range 2 4)) /) == eval(/ -4 /)
    }
}
