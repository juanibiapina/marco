package tests.marco.lang.functions.booleans

import helpers.MarcoSpecification

class _if extends MarcoSpecification {
    def "then clause"() {
        expect:
        eval(/ (if (nil? nil) { (+ 42 3) } { (error "here") }) /) == eval(/ 45 /)
    }

    def "else clause"() {
        expect:
        eval(/ (if (list? 4) { (error "here") } { (+ 3 6) }) /) == eval(/ 9 /)
    }
}
