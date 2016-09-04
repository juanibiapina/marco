package tests.marco.lang.types

import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class numbers extends MarcoSpecification {
    def "return themselves"() {
        expect:
        eval(/ 1 /) == new MarcoNumber(1)
    }

    def "string representation"() {
        expect:
        new MarcoNumber(2).toString() == "2"
    }
}
