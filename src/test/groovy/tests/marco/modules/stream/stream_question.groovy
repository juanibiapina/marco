package tests.marco.modules.stream

import helpers.MarcoSpecification

class stream_question extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "empty stream is a stream"() {
        expect:
        eval(/ (stream.stream? stream.empty) /) == eval(/ true /)
    }

    def "second element is a function"() {
        expect:
        eval(/ (stream.stream? (stream.cons 1 +)) /) == eval(/ true /)
    }

    def "second element is not a function"() {
        expect:
        eval(/ (stream.stream? (stream.cons 1 2)) /) == eval(/ false /)
    }
}
