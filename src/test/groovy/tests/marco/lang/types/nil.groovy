package tests.marco.lang.types

import helpers.MarcoSpecification
import marco.lang.MarcoNil

class nil extends MarcoSpecification {
    def "is defined"() {
        expect:
        eval(/ nil /) == new MarcoNil()
    }

    def "string representation"() {
        expect:
        new MarcoNil().toString() == "nil"
    }
}
