import helpers.MarcoSpecification
import marco.lang.MarcoNil
import marco.lang.MarcoNumber
import marco.lang.MarcoPair
import marco.lang.MarcoString
import marco.lang.MarcoSymbol

class Quote extends MarcoSpecification {
    def "values"() {
        expect:
        eval(/ (quote 1) /) == new MarcoNumber(1)
        eval(/ (quote "string") /) == new MarcoString("string")
    }

    def "list"() {
        expect:
        eval(/ (quote (+ 1 2)) /).toString() == "('+, (1, (2, nil)))"
    }

    def "syntactic quote"() {
        expect:
        eval(/ 'x /) == new MarcoSymbol("x")
        eval(/ '34 /) == new MarcoNumber(34)
        eval(/ '(1 2) /) == new MarcoPair(new MarcoNumber(1), new MarcoPair(new MarcoNumber(2), MarcoNil.NIL))
    }

    def "literal lists"() {
        expect:
        eval(/ [1 2] /) == new MarcoPair(new MarcoNumber(1), new MarcoPair(new MarcoNumber(2), MarcoNil.NIL))
    }
}
