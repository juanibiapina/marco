import helpers.MarcoSpecification
import marco.lang.MarcoNumber
import marco.lang.MarcoString

class Eval extends MarcoSpecification {
    def "values"() {
        expect:
        eval(/ (eval 1) /) == new MarcoNumber(1)
        eval(/ (eval "string") /) == new MarcoString("string")
    }

    def "lists"() {
        expect:
        eval(/ (eval (quote (+ 1 2))) /) == new MarcoNumber(3)
    }

    def "in a function"() {
        expect:
        eval(/ (def :f (function [:l] (eval l))) /)
    }
}
