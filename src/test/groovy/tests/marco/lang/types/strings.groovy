package tests.marco.lang.types

import helpers.MarcoSpecification
import marco.lang.MarcoString

class strings extends MarcoSpecification {
    def "return themselves"() {
        expect:
        eval(/ "some string" /) == new MarcoString("some string")
    }

    def "string representation"() {
        expect:
        new MarcoString("value").toString() == "value"
    }
}
