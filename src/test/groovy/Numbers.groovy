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

    def "sum"() {
        expect:
        eval(/ (+ 1 2) /) == new MarcoNumber(3)
    }

    def "multiplication"() {
        expect:
        eval(/ (* 0 1) /) == eval(/ 0 /)
        eval(/ (* 1 10) /) == eval(/ 10 /)
        eval(/ (* 3 4) /) == eval(/ 12 /)
    }

    def "division"() {
        expect:
        eval(" (/ 1 1) ") == eval(/ 1 /)
        eval(" (/ 0 1) ") == eval(/ 0 /)
        eval(" (/ 2 1) ") == eval(/ 2 /)
        eval(" (/ 8 2) ") == eval(/ 4 /)
        eval(" (/ 8 3) ") == eval(/ 2 /)
    }

    def "remainder"() {
        expect:
        eval(/ (% 4 1) /) == eval(/ 0 /)
        eval(/ (% 4 2) /) == eval(/ 0 /)
        eval(/ (% 4 3) /) == eval(/ 1 /)
    }

    def "even?"() {
        expect:
        eval(/ (even? 0) /) == eval(/ true /)
        eval(/ (even? 1) /) == eval(/ false /)
        eval(/ (even? 2) /) == eval(/ true /)
    }
}
