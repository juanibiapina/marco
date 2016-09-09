package tests.marco.modules.string

import helpers.MarcoSpecification

class from extends MarcoSpecification {
    def setup() {
        given:
        eval(/ (def :string (require "string")) /)
    }

    def "numbers"() {
        expect:
        eval(/ (string.from 1) /) == eval(/ "1" /)
        eval(/ (string.from -2) /) == eval(/ "-2" /)
    }
}
