package tests.marco.features

import helpers.MarcoSpecification

class NameLookup extends MarcoSpecification {
    def "look up values in the environment"() {
        when:
        eval(/ (def :x 2) /)

        then:
        eval(/ x /) == eval(/ 2 /)
    }

    def "with numbers"() {
        when:
        eval(/ (def :value1 "haha") /)

        then:
        eval(/ value1 /) == eval(/ "haha" /)
    }
}
