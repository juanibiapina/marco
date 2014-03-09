package marco

import helpers.MarcoSpecification

class do_specialform extends MarcoSpecification {
    def "with mutable vars"() {
        expect:
        eval(/ (do ((var x 2) (set! x (+ x 1)) x)) /) == eval(/ 3 /)
    }
}
