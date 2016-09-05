package tests.marco.modules.stream

import helpers.MarcoSpecification
import marco.lang.MarcoNil
import marco.lang.MarcoNumber
import marco.lang.MarcoPair

class head extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "head of a stream"() {
        given:
        eval(/ (def :s (stream.cons 1 stream.empty)) /)

        expect:
        eval(/ (stream.head s) /) == eval(/ 1 /)
    }
}
