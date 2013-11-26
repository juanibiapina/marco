import helpers.MarcoSpecification
import marco.lang.MarcoBoolean
import marco.internal.Cast

class Booleans extends MarcoSpecification {
    def "string representation"() {
        expect:
        MarcoBoolean.TRUE.toString() == "true"
        MarcoBoolean.FALSE.toString() == "false"
    }

    def "true is defined"() {
        expect:
        eval(/ true /) == MarcoBoolean.TRUE
    }

    def "false is defined"() {
        eval(/ false /) == MarcoBoolean.FALSE
    }

    def "false is false"() {
        when:
        def result = eval(/ false /)

        then:
        Cast.toBoolean(result) == MarcoBoolean.FALSE
    }

    def "true is true"() {
        when:
        def result = eval(/ true /)

        then:
        Cast.toBoolean(result) == MarcoBoolean.TRUE
    }

    def "nil is false"() {
        when:
        def result = eval(/ nil /)

        then:
        Cast.toBoolean(result) == MarcoBoolean.FALSE
    }

    def "numbers are true"() {
        when:
        def number0 = eval(/ 0 /)
        def number1 = eval(/ 1 /)

        then:
        Cast.toBoolean(number0) == MarcoBoolean.TRUE
        Cast.toBoolean(number1) == MarcoBoolean.TRUE
    }
}
