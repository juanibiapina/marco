package tests.marco.modules.stream

import helpers.MarcoSpecification
import marco.lang.MarcoNil
import marco.lang.MarcoNumber
import marco.lang.MarcoPair

class empty extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "empty stream is empty"() {
        expect:
        eval(/ (stream.empty? stream.empty) /) == eval(/ true /)
    }

    def "function is not an empty stream"() {
        expect:
        eval(/ (stream.empty? stream.empty) /) == eval(/ true /)
    }
}
