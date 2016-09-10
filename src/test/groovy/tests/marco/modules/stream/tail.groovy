package tests.marco.modules.stream

import helpers.MarcoSpecification

class tail extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "tail of a stream"() {
        given:
        eval(/ (def :s (stream.cons 1 (function [] { stream.empty }))) /)

        expect:
        eval(/ (stream.tail s) /) == eval(/ stream.empty /)
    }
}
