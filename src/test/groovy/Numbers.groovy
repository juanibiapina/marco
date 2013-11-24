import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Numbers extends MarcoSpecification {
    def "return themselves"() {
        expect:
        eval(/ 1 /) == new MarcoNumber(1)
    }

    def "string representation"() {
        expect:
        new MarcoNumber(2).toString() == "2"
    }

    def "+ function"() {
        expect:
        eval(/ (+ 1 2) /) == new MarcoNumber(3)
    }
}
