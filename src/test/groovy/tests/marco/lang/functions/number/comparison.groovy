package tests.marco.lang.functions.number

import helpers.MarcoSpecification

class comparison extends MarcoSpecification {
    def "="() {
        expect:
        eval(/ (= 1 1) /) == eval(/ true /)
        eval(/ (= 0 1) /) == eval(/ false /)
        eval(/ (= 1 0) /) == eval(/ false /)
    }

    def "<"() {
        expect:
        eval(/ (< 1 3) /) == eval(/ true /)
        eval(/ (< 3 3) /) == eval(/ false /)
        eval(/ (< 3 1) /) == eval(/ false /)
        eval(/ (< -1 0) /) == eval(/ true /)
    }

    def "<="() {
        expect:
        eval(/ (<= 1 3) /) == eval(/ true /)
        eval(/ (<= 3 3) /) == eval(/ true /)
        eval(/ (<= 3 1) /) == eval(/ false /)
        eval(/ (<= -1 0) /) == eval(/ true /)
    }

    def ">"() {
        expect:
        eval(/ (> 1 3) /) == eval(/ false /)
        eval(/ (> 3 3) /) == eval(/ false /)
        eval(/ (> 3 1) /) == eval(/ true /)
    }

    def ">="() {
        expect:
        eval(/ (>= 1 3) /) == eval(/ false /)
        eval(/ (>= 3 3) /) == eval(/ true /)
        eval(/ (>= 3 1) /) == eval(/ true /)
    }
}
