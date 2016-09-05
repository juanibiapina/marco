package tests.marco.modules.stream

import helpers.MarcoSpecification

class tail extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "tail of a one element stream"() {
        given:
        eval(/ (def :s (stream.cons 1 stream.empty)) /)

        expect:
        eval(/ (stream.tail s) /) == eval(/ stream.empty /)
    }

    def "tail a two element stream"() {
        expect:
        eval(/ (stream.tail (stream.cons 1 (function [] { (stream.cons 2 stream.empty) }))) /) == eval(/ (stream.cons 2 stream.empty) /)
    }
}
