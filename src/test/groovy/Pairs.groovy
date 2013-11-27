import helpers.MarcoSpecification
import marco.lang.MarcoBoolean
import marco.lang.MarcoNumber
import marco.lang.MarcoPair

class Pairs extends MarcoSpecification {
    def "creating a pair"() {
        expect:
        eval(/ (cons 1 2) /) == new MarcoPair(new MarcoNumber(1), new MarcoNumber(2))
    }

    def "first"() {
        expect:
        eval(/ (first (cons true "value")) /) == MarcoBoolean.TRUE
    }

    def "second"() {
        expect:
        eval(/ (second (cons (cons 1 2) 42)) /) == new MarcoNumber(42)
    }
}
