import helpers.MarcoSpecification

class Equality extends MarcoSpecification {
    def "numbers"() {
        expect:
        eval(/ (equal? 1 2) /) == eval(/ false /)
        eval(/ (equal? 1 1) /) == eval(/ true /)
    }
}
