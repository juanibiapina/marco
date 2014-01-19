import helpers.MarcoSpecification
import marco.lang.MarcoNil

class Nil extends MarcoSpecification {
    def "is defined"() {
        expect:
        eval(/ nil /) == new MarcoNil()
    }

    def "nil?"() {
        expect:
        eval(/ (nil? 1) /) == eval(/ false /)
        eval(/ (nil? nil) /) == eval(/ true /)
    }

    def "string representation"() {
        expect:
        new MarcoNil().toString() == "nil"
    }
}
