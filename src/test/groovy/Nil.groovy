import helpers.MarcoSpecification
import marco.lang.MarcoBoolean
import marco.lang.MarcoNil

class Nil extends MarcoSpecification {
    def "is defined"() {
        expect:
        eval(/ nil /) == new MarcoNil()
    }

    def "nil?"() {
        expect:
        eval(/ (nil? 1) /) == MarcoBoolean.FALSE
        eval(/ (nil? nil) /) == MarcoBoolean.TRUE
    }

    def "string representation"() {
        expect:
        new MarcoNil().toString() == "nil"
    }
}
