package tests.marco.lang.functions.numbers

import helpers.MarcoSpecification

class arithmetic extends MarcoSpecification {
    def "sum"() {
        expect:
        eval(/ (+ 1 2) /) == eval(/ 3 /)
    }

    def "subtraction"() {
        expect:
        eval(/ (- 2 1) /) == eval(/ 1 /)
        eval(/ (- 1 2) /) == eval(/ -1 /)
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
}
