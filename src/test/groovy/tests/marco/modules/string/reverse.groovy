package tests.marco.modules.string

import helpers.MarcoSpecification

class reverse extends MarcoSpecification {
    def setup() {
        given:
        eval(/ (def :string (require "string")) /)
    }

    def "reversing"() {
        expect:
        eval(/ (string.reverse "abcd?") /) == eval(/ "?dcba" /)
    }
}
