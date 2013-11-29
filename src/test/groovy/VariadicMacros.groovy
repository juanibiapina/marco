import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class VariadicMacros extends MarcoSpecification {
    def "receive a list"() {
        when:
        eval(/ (def f (macro args (eval (first args)))) /)

        then:
        eval(/ (f (+ 1 2) (error "here") 3) /) == new MarcoNumber(3)
    }
}
