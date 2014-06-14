import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class If extends MarcoSpecification {
    def "then clause"() {
        expect:
        eval(/ (if (nil? nil) { (+ 42 3) } { (error "here") }) /) == new MarcoNumber(45)
    }

    def "else clause"() {
        expect:
        eval(/ (if (list? 4) { (error "here") } { (+ 3 6) }) /) == new MarcoNumber(9)
    }
}
