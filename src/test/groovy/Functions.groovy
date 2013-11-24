import helpers.MarcoSpecification
import marco.MarcoLookUpError
import marco.lang.MarcoNumber

class Functions extends MarcoSpecification {
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

    def "subsequent environment is not available to function body"() {
        when:
        eval(/ (def f (function () s)) /)
        eval(/ (def s 6) /)
        eval(/ (f) /)

        then:
        MarcoLookUpError e = thrown()
        e.binding == "s"
    }
}
