package tests.marco.modules.core

import helpers.MarcoSpecification

class for_each extends MarcoSpecification {
    def "does nothing for the empty list"() {
        given:
        eval(/ (var :result []) /)
        eval(/ (def :f (function [:n] { (set! :result (cons (+ n 1) result)) })) /)

        when:
        eval(/ (for-each [] f) /)

        then:
        eval(/ result /) == eval(/ [] /)
    }

    def "applies the function for each element of the list"() {
        given:
        eval(/ (var :result []) /)
        eval(/ (def :f (function [:n] { (set! :result (cons (+ n 1) result)) })) /)

        when:
        eval(/ (for-each [1 2 3 4] f) /)

        then:
        eval(/ result /) == eval(/ [5 4 3 2] /)
    }
}
