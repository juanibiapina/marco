package marco

import helpers.MarcoSpecification

class while_specialform extends MarcoSpecification {
    def "simple case"() {
        given:
        eval(/ (var x 5) /)

        when:
        eval(/ (while (> x 0) (set! x (- x 1))) /)

        then:
        eval(/ x /) == eval(/ 0 /)
    }
}
