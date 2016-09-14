package tests.marco.modules.stream

import helpers.MarcoSpecification

class tail extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "tail of a stream"() {
        expect:
        eval(/ (stream.head (stream.tail (stream.integers))) /) == eval(/ 2 /)
    }
}
