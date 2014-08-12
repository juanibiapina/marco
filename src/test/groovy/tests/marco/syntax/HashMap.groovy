package tests.marco.syntax

import helpers.MarcoSpecification

class HashMap extends MarcoSpecification {
    def "syntax"() {
        expect:
        eval(/ #{:a 1 :b 2} /) == eval(/ (hash-map [:a 1 :b 2]) /)
    }

    def "evaluates inner elements"() {
        expect:
        eval(/ #{:a (+ 1 2)} /) == eval(/ (hash-map [:a 3]) /)
    }
}
