package tests.marco.modules

import helpers.MarcoSpecification

class integer extends MarcoSpecification {
    def "parse"() {
        given:
        eval(/ (def :integer (require "integer")) /)

        expect:
        eval(/ (integer.parse "0") /) == eval(/ 0 /)
    }

    def "range"() {
        given:
        eval(/ (def :integer (require "integer")) /)

        expect:
        eval(/ (integer.range 2 7) /) == eval(/ [2 3 4 5 6] /)
    }
}
