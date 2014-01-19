package marco
import helpers.MarcoSpecification

class core extends MarcoSpecification {
    def "head"() {
        expect:
        eval(/ (head '(1 2 3 4)) /) == eval(/ 1 /)
    }

    def "tail"() {
        expect:
        eval(/ (tail '(1 2 3)) /) == eval(/ '(2 3) /)
    }

    def "or"() {
        expect:
        eval(/ (or 1 2) /) == eval(/ 1 /)
        eval(/ (or false 2) /) == eval(/ 2 /)
        eval(/ (or false false) /) == eval(/ false /)
        eval(/ (or "string" true) /) == eval(/ "string" /)
        eval(/ (or 0 5) /) == eval(/ 0 /)
        eval(/ (or "" "s") /) == eval(/ "" /)
        eval(/ (or '(1 2) true) /) == eval(/ '(1 2) /)

        eval(/ (or true (error "never happens")) /) == eval(/ true /)
    }

    def "and"() {
        expect:
        eval(/ (and 1 2) /) == eval(/ 2 /)
        eval(/ (and false 1) /) == eval(/ false /)
        eval(/ (and "string" "hi") /) == eval(/ "hi" /)
        eval(/ (and false (error "never happens")) /) == eval(/ false /)
    }

    def "map"() {
        expect:
        eval(/ (map (function (x) (+ x 1)) '(1 2 3)) /) == eval(/ '(2 3 4) /)
    }
}
