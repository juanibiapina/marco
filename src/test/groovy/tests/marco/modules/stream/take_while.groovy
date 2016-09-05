package tests.marco.modules.stream

import helpers.MarcoSpecification

class take_while extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "taking elements smaller than 5"() {
        expect:
        eval(/ (stream.take-while (function [:n] { (< n 5) }) (stream.integers)) /) == eval(/ [1 2 3 4] /)
    }
}
