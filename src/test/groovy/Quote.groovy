import helpers.MarcoSpecification
import marco.lang.MarcoNumber
import marco.lang.MarcoString

class Quote extends MarcoSpecification {
    def "values"() {
        expect:
        eval(/ (quote 1) /) == new MarcoNumber(1)
        eval(/ (quote "string") /) == new MarcoString("string")
    }

    def "list"() {
        expect:
        eval(/ (quote (+ 1 2)) /).toString() == "List" // TODO: test for contents
    }
}
