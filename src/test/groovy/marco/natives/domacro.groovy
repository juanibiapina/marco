package marco.natives

import helpers.MarcoSpecification

class domacro extends MarcoSpecification {
    def "with mutable vars"() {
        expect:
        eval(/ (do ((var x 2) (set! x (+ x 1)) x)) /) == eval(/ 3 /)
    }
}
