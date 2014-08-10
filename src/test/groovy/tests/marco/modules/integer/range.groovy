package tests.marco.modules.integer

import helpers.MarcoSpecification

class range extends MarcoSpecification {
    def "2 to 7"() {
        given:
        eval(/ (def :integer (require "integer")) /)

        expect:
        eval(/ (integer.range 2 7) /) == eval(/ [2 3 4 5 6] /)
    }
}
