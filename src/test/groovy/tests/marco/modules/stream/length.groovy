package tests.marco.modules.stream

import helpers.MarcoSpecification

class length extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "empty stream is zero"() {
        expect:
        eval(/ (stream.length stream.empty) /) == eval(/ 0 /)
    }

    def "length of a range"() {
        expect:
        eval(/ (stream.length (stream.range 3 6)) /) == eval(/ 3 /)
    }
}
