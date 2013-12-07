package marco.natives

import helpers.MarcoSpecification

class equal extends MarcoSpecification {
    def "integers"() {
        expect:
        eval(/ (= 1 1) /) == eval(/ true /)
        eval(/ (= 0 1) /) == eval(/ false /)
    }
}
