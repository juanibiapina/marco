package tests.marco.modules.stream

import helpers.MarcoSpecification
import marco.lang.MarcoNil
import marco.lang.MarcoNumber
import marco.lang.MarcoPair
import marco.lang.exceptions.TypeException
import spock.lang.Ignore

class cons extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "building a one element stream"() {
        expect:
        eval(/ (stream.cons 1 stream.empty) /) == new MarcoPair(new MarcoNumber(1), MarcoNil.NIL)
    }

    def "building a two element stream"() {
        expect:
        eval(/ (stream.cons 1 (function [] { (stream.con 1 stream.empty) })) /)
    }

    @Ignore("Need exception throwing")
    def "wrong type of stream tail"() {
        when:
        eval(/ (stream.cons 1 2) /)

        then:
        TypeException e = thrown()
        e.expected == "Function"
        e.actual == eval(/ 2 /)
    }
}
