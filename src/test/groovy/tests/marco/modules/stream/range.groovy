package tests.marco.modules.stream

import helpers.MarcoSpecification

class range extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "returns a stream"() {
        expect:
        eval(/ (stream.stream? (stream.range 3 6)) /) == eval(/ true /)
    }

    def "has bounds"() {
        expect:
        eval(/ (stream.length (stream.range 3 6)) /) == eval(/ 3 /)
    }
}
