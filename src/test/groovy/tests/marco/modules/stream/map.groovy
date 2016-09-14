package tests.marco.modules.stream

import helpers.MarcoSpecification

class map extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
        eval(/ (def :inc (partial 1 [+ 1])) /)
    }

    def "empty stream"() {
        expect:
        eval(/ (stream.map inc stream.empty) /) == eval(/ stream.empty /)
    }

    def "infinite stream"() {
        expect:
        eval(/ (stream.take 5 (stream.map inc (stream.integers))) /) == eval(/ [2 3 4 5 6] /)
    }
}
