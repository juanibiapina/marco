package tests.marco.modules.list

import helpers.MarcoSpecification

class foldl extends MarcoSpecification {
    def "with an empty list returns the initial element"() {
        given:
        eval(/ (def :pred (function [:e1 :e2] { (+ e1 e2) }))  /)

        expect:
        eval(/ (foldl pred 42 []) /) == eval(/ 42 /)
    }

    def "with an non empty list, applies the fold logic"() {
        given:
        eval(/ (def :pred (function [:e1 :e2] { (+ e1 e2) }))  /)

        expect:
        eval(/ (foldl pred 1 [1 2 3 4]) /) == eval(/ 11 /)
    }
}
