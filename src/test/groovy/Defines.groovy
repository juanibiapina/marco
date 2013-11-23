import helpers.MarcoSpecification
import marco.lang.MarcoNumber
import marco.lang.MarcoString

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
}
