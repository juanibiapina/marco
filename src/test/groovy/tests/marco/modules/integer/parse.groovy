package tests.marco.modules.integer

import helpers.MarcoSpecification

class parse extends MarcoSpecification {
    def "zero"() {
        given:
        eval(/ (def :integer (require "integer")) /)

        expect:
        eval(/ (integer.parse "0") /) == eval(/ 0 /)
    }

    def "big number"() {
        given:
        eval(/ (def :integer (require "integer")) /)

        expect:
        eval(/ (integer.parse "600851475143") /) == eval(/ 600851475143 /)
    }
}
