import helpers.MarcoSpecification
import marco.lang.MarcoNil

class Nil extends MarcoSpecification {
    def "is defined"() {
        expect:
        eval(/ nil /) == new MarcoNil()
    }
}
