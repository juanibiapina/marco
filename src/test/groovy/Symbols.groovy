import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Symbols extends MarcoSpecification {
    def "lookUp values in the environment"() {
        when:
        eval(/ (def x 2) /)

        then:
        eval(/ x /) == new MarcoNumber(2)
    }
}
