package tests.marco.lang.functions.nil

import helpers.MarcoSpecification

class nil_question extends MarcoSpecification {
    def "nil?"() {
        expect:
        eval(/ (nil? 1) /) == eval(/ false /)
        eval(/ (nil? nil) /) == eval(/ true /)
    }
}
