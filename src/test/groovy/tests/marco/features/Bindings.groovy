package tests.marco.features

import helpers.MarcoSpecification

import marco.lang.exceptions.ContractViolation
import marco.lang.exceptions.TypeException

class Bindings extends MarcoSpecification {
    def "defining numbers"() {
        when:
        eval(/ (def :x 1) /)

        then:
        eval(/ x /) == eval(/ 1 /)
    }

    def "defining strings"() {
        when:
        eval(/ (def :a_value "string value") /)

        then:
        eval(/ a_value /) == eval(/ "string value" /)
    }

    def "renaming def"() {
        when:
        eval(/ (def :define def) /)
        eval(/ (define :x 1) /)

        then:
        eval(/ x /) == eval(/ 1 /)
    }

    def "defining in terms of other bindings"() {
        when:
        eval(/ (def :x 1) /)
        eval(/ (def :y x) /)

        then:
        eval(/ y /) == eval(/ 1 /)
    }

    def "returns nil"() {
        expect:
        eval(/ (def :xx 11) /) == eval(/ nil /)
    }

    def "first parameter is a symbol"() {
        when:
        eval(/ (def 2 1) /)

        then:
        TypeException e = thrown()
        e.expected == "Symbol"
        e.actual == eval(/ 2 /)
    }

    def "without enough arguments"() {
        when:
        eval(/ (def :x) /)

        then:
        ContractViolation e = thrown()
        e.expected == 2
        e.actual == 1
    }

    def "with extra arguments"() {
        when:
        eval(/ (def :x 1 2) /)

        then:
        ContractViolation e = thrown()
        e.expected == 2
        e.actual == 3
    }
}
