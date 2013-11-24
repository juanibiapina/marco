import helpers.MarcoSpecification
import marco.MarcoTypeError
import marco.lang.MarcoNumber
import marco.lang.MarcoString
import marco.lang.MarcoSymbol

class Defines extends MarcoSpecification {
    def "defining numbers"() {
        when:
        eval(/ (def x 1) /)

        then:
        lookUp("x") == new MarcoNumber(1)
    }

    def "defining strings"() {
        when:
        eval(/ (def a_value "string value") /)

        then:
        lookUp("a_value") == new MarcoString("string value")
    }

    def "defining in terms of other bindings"() {
        when:
        eval(/ (def x 1) /)
        eval(/ (def y x) /)

        then:
        lookUp("y") == new MarcoNumber(1)
    }

    def "first parameter is a symbol"() {
        when:
        eval(/ (def 2 1) /)

        then:
        MarcoTypeError e = thrown()
        e.expected == MarcoSymbol
        e.actual == new MarcoNumber(2)
    }
}
