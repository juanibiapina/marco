import helpers.MarcoSpecification
import marco.lang.MarcoNumber
import marco.lang.exception.ImmutabilityError

class Mutation extends MarcoSpecification {
    def "mutation is not allowed on defs"() {
        given:
        eval(/ (def x 1) /)

        when:
        eval(/ (set! x 2) /)

        then:
        ImmutabilityError e = thrown()
        e.symbol == "x"
    }

    def "mutating a binding"() {
        given:
        eval(/ (var x 1) /)

        when:
        eval(/ (set! x 2) /)

        then:
        eval(/ x /) == eval(/ 2 /)
    }

    def "mutating a binding affects the closure environment"() {
        given:
        eval(/ (var x 1) /)
        eval(/ (def f (function () x)) /)

        when:
        eval(/ (set! x 2) /)

        then:
        eval(/ (f) /) == new MarcoNumber(2)
    }

    def "mutation inside the function affects the outer environment"() {
        given:
        eval(/ (var x 1) /)
        eval(/ (def f (function () (set! x 2))) /)

        when:
        eval(/ (f) /)

        then:
        eval(/ x /) == new MarcoNumber(2)
    }

    def "parameters cannot be mutated"() {
        given:
        eval(/ (var x 1) /)
        eval(/ (def f (function (x) (set! x 2))) /)

        when:
        eval(/ (f 3) /)

        then:
        ImmutabilityError e = thrown()
        e.symbol == "x"
    }
}
