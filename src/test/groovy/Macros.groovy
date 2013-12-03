import helpers.MarcoSpecification
import marco.lang.MarcoBoolean
import marco.lang.MarcoNumber
import marco.lang.MarcoString

class Macros extends MarcoSpecification {
    def "with no arguments"() {
        when:
        eval(/ (def m (macro () true)) /)

        then:
        eval(/ (m) /) == MarcoBoolean.TRUE;
    }

    def "with one argument that is not used"() {
        when:
        eval(/ (def m (macro (e1) 1)) /)

        then:
        eval(/ (m (error "should not happen")) /) == new MarcoNumber(1)
    }

    def "with two arguments that are not used"() {
        when:
        eval(/ (def m (macro (e1 e2) "result")) /)

        then:
        eval(/ (m (error "should not happen") some_symbol) /) == new MarcoString("result")
    }

    def "evaluating one of the arguments but not the other"() {
        when:
        eval(/ (def m (macro (e1 e2) (eval e1))) /)

        then:
        eval(/ (m (+ 1 2) (error "should not eval")) /) == new MarcoNumber(3)
    }

    def "arguments have lexical scope"() {
        when:
        eval(/ (def x 1) /)
        eval(/ (def m (macro (e) (eval e))) /)
        eval(/ (def r (function (x) (m x))) /)

        then:
        eval(/ (r 2) /) == new MarcoNumber(2)
    }
}
