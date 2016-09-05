package tests.marco.modules.stream

import helpers.MarcoSpecification

class take extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "taking 1 element"() {
        expect:
        eval(/ (stream.take 1 (stream.integers)) /) == eval(/ [1] /)
    }

    def "taking several elements"() {
        expect:
        eval(/ (stream.take 4 (stream.integers)) /) == eval(/ [1 2 3 4] /)
    }
}
