import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Mutation extends MarcoSpecification {
    def "mutating a binding"() {
        given:
        eval(/ (def x 1) /)

        when:
        eval(/ (set! x 2) /)

        then:
        eval(/ x /) == new MarcoNumber(2)
    }

    def "mutating a binding affects the closure environment"() {
        given:
        eval(/ (def x 1) /)
        eval(/ (def f (function () x)) /)

        when:
        eval(/ (set! x 2) /)

        then:
        eval(/ (f) /) == new MarcoNumber(2)
    }

    def "mutation inside the function affects the outer environment"() {
        given:
        eval(/ (def x 1) /)
        eval(/ (def f (function () (set! x 2))) /)

        when:
        eval(/ (f) /)

        then:
        eval(/ x /) == new MarcoNumber(2)
    }

    def "parameter mutation does not affect the outer environment"() {
        given:
        eval(/ (def x 1) /)
        eval(/ (def f (function (x) (set! x 2))) /)

        when:
        eval(/ (f 3) /)

        then:
        eval(/ x /) == new MarcoNumber(1)
    }
}
