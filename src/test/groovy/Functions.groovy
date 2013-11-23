import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Functions extends MarcoSpecification {
    def "takes 1 parameter and return it"() {
        when:
        runtime.eval(/ (def f (function (x) x)) /)

        then:
        runtime.eval(/ (f 42) /) == new MarcoNumber(42)
    }

    def "takes 2 parameters and return the second"() {
        when:
        runtime.eval(/ (def f (function (x y) y)) /)

        then:
        runtime.eval(/ (f 3 4) /) == new MarcoNumber(4)
    }
}
