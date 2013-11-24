import helpers.MarcoSpecification
import marco.lang.MarcoString

class Strings extends MarcoSpecification {
    def "return themselves"() {
        expect:
        eval(/ "some string" /) == new MarcoString("some string")
    }

    def "string representation"() {
        expect:
        new MarcoString("value").toString() == /"value"/
    }
}
