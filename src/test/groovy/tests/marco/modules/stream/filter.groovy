package tests.marco.modules.stream

import helpers.MarcoSpecification

class filter extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "filtering from a stream"() {
        expect:
        eval(/ (stream.take 3 (stream.filter even? (stream.integers))) /) == eval(/ [2 4 6] /)
    }
}
