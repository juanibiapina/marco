import helpers.MarcoSpecification
import marco.lang.MarcoSymbol

class Symbols extends MarcoSpecification {
    def "evaluate to themselves"() {
        expect:
        eval(/ :symbol /) == new MarcoSymbol("symbol")
    }
}
