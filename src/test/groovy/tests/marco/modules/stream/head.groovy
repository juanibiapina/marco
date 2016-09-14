package tests.marco.modules.stream
import helpers.MarcoSpecification

class head extends MarcoSpecification {
    def "setup"() {
        eval(/ (def :stream (require "stream")) /)
    }

    def "head of a stream"() {
        expect:
        eval(/ (stream.head (stream.integers)) /) == eval(/ 1 /)
    }
}
