import helpers.MarcoSpecification
import marco.lang.MarcoName

class Names extends MarcoSpecification {
    def "look up values in the environment"() {
        when:
        eval(/ (def x 2) /)

        then:
        eval(/ x /) == eval(/ 2 /)
    }

    def "string representation"() {
        expect:
        new MarcoName("x").toString() == "'x"
    }

    def "with numbers"() {
        when:
        eval(/ (def value1 "haha") /)

        then:
        eval(/ value1 /) == eval(/ "haha" /)
    }
}
