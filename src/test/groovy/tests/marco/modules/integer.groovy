package tests.marco.modules

import helpers.MarcoSpecification

class integer extends MarcoSpecification {
    def "parse"() {
        given:
        eval(/ (def :integer (require "integer")) /)

        expect:
        eval(/ (integer.parse "0") /) == eval(/ 0 /)
    }
}
