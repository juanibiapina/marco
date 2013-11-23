import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Functions extends MarcoSpecification {
    def "takes 1 parameter and return it"() {
        when:
        eval(/ (def f (function (x) x)) /)

        then:
        eval(/ (f 42) /) == new MarcoNumber(42)
    }

    def "takes 2 parameters and return the second"() {
        when:
        eval(/ (def f (function (x y) y)) /)

        then:
        eval(/ (f 3 4) /) == new MarcoNumber(4)
    }
}
