import helpers.MarcoSpecification
import marco.lang.*

class Quote extends MarcoSpecification {
    def "values"() {
        expect:
        eval(/ (quote 1) /) == new MarcoNumber(1)
        eval(/ (quote "string") /) == new MarcoString("string")
    }

    def "syntactic quote"() {
        expect:
        eval(/ 'x /) == new MarcoSymbol("x")
        eval(/ '34 /) == new MarcoNumber(34)
        eval(/ '[1 2] /) == new MarcoPair(new MarcoNumber(1), new MarcoPair(new MarcoNumber(2), MarcoNil.NIL))
    }
}
