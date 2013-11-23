import helpers.MarcoSpecification
import marco.lang.MarcoNumber
import marco.lang.MarcoString

class Defines extends MarcoSpecification {
    def "defining numbers"() {
        when:
        runtime.eval(/ (def x 1) /)

        then:
        runtime.environment.lookUp("x") == new MarcoNumber(1)
    }

    def "defining strings"() {
        when:
        runtime.eval(/ (def a_value "string value") /)

        then:
        runtime.environment.lookUp("a_value") == new MarcoString("string value")
    }

    def "defining in terms of other bindings"() {
        when:
        runtime.eval(/ (def x 1) /)
        runtime.eval(/ (def y x) /)

        then:
        runtime.environment.lookUp("y") == new MarcoNumber(1)
    }
}
