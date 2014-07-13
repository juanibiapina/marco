package tests.marco.modules
import helpers.MarcoSpecification

class io extends MarcoSpecification {
    def "stdin"() {
        given:
        eval(/ (def :io (require "io")) /)
        eval(/ (def :native (require "native")) /)

        expect:
        eval(/ io.stdin /) == eval(/ native.stdin /)
    }

    def "read-line"() {
        given:
        eval(/ (def :io (require "io")) /)
        eval(/ (def :native (require "native")) /)

        expect:
        eval(/ io.read-line /) == eval(/ native.read-line /)
    }
}
