import helpers.MarcoSpecification
import marco.lang.MarcoBoolean
import marco.lang.MarcoNil

class VariadicFunctions extends MarcoSpecification {
    def "receive a pair"() {
        when:
        eval(/ (def f (function args (pair? args))) /)

        then:
        eval(/ (f 1 2 3) /) == MarcoBoolean.TRUE
    }

    def "actually receive a list"() {
        when:
        eval(/ (def f (function args (second (second args)))) /)

        then:
        eval(/ (f 1 2) /) == MarcoNil.NIL
    }
}
