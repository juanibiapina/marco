package tests.marco.lang.types

import helpers.MarcoSpecification
import marco.lang.MarcoSymbol

class symbols extends MarcoSpecification {
    def "evaluate to themselves"() {
        expect:
        eval(/ :symbol /) == new MarcoSymbol("symbol")
    }
}
