package tests.marco.modules.core

import helpers.MarcoSpecification

class flip extends MarcoSpecification {
    def "flips the arguments of a function"() {
        given:
        eval(/ (def :f (function [:e1 :e2] { (pair e1 e2) })) /)

        when:
        eval(/ (def :g (flip f)) /)

        then:
        eval(/ (g 1 2) /) == eval(/ (pair 2 1) /)
    }
}
