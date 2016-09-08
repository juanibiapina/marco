package tests.marco.features

import helpers.MarcoSpecification

class PartialApplication extends MarcoSpecification {
    def "of a function with 2 parameters taking 1"() {
        when:
        eval(/ (def :f1 (partial 1 [- 1])) /)

        then:
        eval(/ (f1 2) /) == eval(/ -1 /)
    }

    def "of a function with 3 parameters taking 1"() {
        given:
        eval(/ (def :f3 (function [:a1 :a2 :a3] { (- (- a1 a2) a3) })) /)

        when:
        eval(/ (def :f (partial 1 [f3 1 2])) /)

        then:
        eval(/ (f 3) /) == eval(/ -4 /)
    }

    def "of a function with 3 parameters taking 2"() {
        given:
        eval(/ (def :f3 (function [:a1 :a2 :a3] { (- (- a1 a2) a3) })) /)

        when:
        eval(/ (def :f (partial 2 [f3 1])) /)

        then:
        eval(/ (f 3 4) /) == eval(/ -6 /)
    }
}
