import helpers.MarcoSpecification
import marco.lang.MarcoList
import marco.lang.MarcoNumber
import marco.lang.MarcoSymbol
import marco.lang.exception.ContractViolation
import marco.lang.exception.MarcoTypeError

class Functions extends MarcoSpecification {
    def "type"() {
        expect:
        eval(/ (function? (function () x)) /) == eval(/ true /)
        eval(/ (function? 1) /) == eval(/ false /)
        eval(/ (function? def) /) == eval(/ false /)
    }

    def "zero argument function"() {
        when:
        eval(/ (def some_function (function () 4)) /)

        then:
        eval(/ (some_function) /) == new MarcoNumber(4)
    }

    def "takes 1 parameter and returns it"() {
        when:
        eval(/ (def f (function (x) x)) /)

        then:
        eval(/ (f 42) /) == new MarcoNumber(42)
    }

    def "takes 2 parameters and returns the second"() {
        when:
        eval(/ (def f (function (x y) y)) /)

        then:
        eval(/ (f 3 4) /) == new MarcoNumber(4)
    }

    def "parameters shadow previous bindings"() {
        when:
        eval(/ (def x 1) /)
        eval(/ (def f (function (x) x)) /)

        then:
        eval(/ (f 2) /) == new MarcoNumber(2)
    }

    def "previous environment is available to function body"() {
        when:
        eval(/ (def p 5) /)
        eval(/ (def f (function (x) p)) /)

        then:
        eval(/ (f 3) /) == new MarcoNumber(5)
    }

    def "subsequent environment is available to function body"() {
        when:
        eval(/ (def f (function () s)) /)
        eval(/ (def s 6) /)

        then:
        eval(/ (f) /) == new MarcoNumber(6)
    }

    def "error when argument is not a list"() {
        when:
        eval(/ (def f (function 1 x)) /)

        then:
        MarcoTypeError e = thrown()
        e.expected == MarcoList
        e.actual == new MarcoNumber(1)
    }

    def "error when arguments aren't symbols"() {
        when:
        eval(/ (def f (function (x y 1) x)) /)

        then:
        MarcoTypeError e = thrown()
        e.expected == MarcoSymbol
        e.actual == new MarcoNumber(1)
    }

    def "error when defining a function with too few arguments"() {
        when:
        eval(/ (def f (function 1)) /)

        then:
        ContractViolation e = thrown()
        e.expected == 2
        e.actual == 1
    }

    def "error when defining a function with too many arguments"() {
        when:
        eval(/ (def f (function (x y) x y)) /)

        then:
        ContractViolation e = thrown()
        e.expected == 2
        e.actual == 3
    }

    def "call with too many arguments"() {
        given:
        eval(/ (def f (function (x) x)) /)

        when:
        eval(/ (f 1 2) /)

        then:
        ContractViolation e = thrown()
        e.expected == 1
        e.actual == 2
    }

    def "call with too few arguments"() {
        given:
        eval(/ (def f (function (x y) x)) /)

        when:
        eval(/ (f 1) /)

        then:
        ContractViolation e = thrown()
        e.expected == 2
        e.actual == 1
    }
}
