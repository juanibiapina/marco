import marco.lang.MarcoNumber
import marco.lang.MarcoString
import spock.lang.Specification

class StringRepresentations extends Specification {
    def "MarcoNumber"() {
        expect:
        new MarcoNumber(2).toString() == "2"
    }

    def "MarcoString"() {
        expect:
        new MarcoString("value").toString() == /"value"/
    }
}
