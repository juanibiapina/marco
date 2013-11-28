import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Lists extends MarcoSpecification {
    def "first"() {
        expect:
        eval(/ (first (quote (1 2))) /) == new MarcoNumber(1)
    }

    def "second"() {
        expect:
        eval(/ (first (second (quote (1 2 3))) /) == new MarcoNumber(2)
    }
}
