package tests.marco.modules
import helpers.MarcoSpecification

class io extends MarcoSpecification {
    def "stdin"() {
        given:
        eval(/ (def :io (require "io")) /)
        eval(/ (def :native-io (require-native "io")) /)

        expect:
        eval(/ io.stdin /) == eval(/ native-io.stdin /)
    }

    def "read-line"() {
        given:
        eval(/ (def :io (require "io")) /)
        eval(/ (def :native-io (require-native "io")) /)

        expect:
        eval(/ io.read-line /) == eval(/ native-io.read-line /)
    }
}
