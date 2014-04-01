package marco
import helpers.MarcoSpecification

class core extends MarcoSpecification {
    def "head"() {
        expect:
        eval(/ (head [1 2 3 4]) /) == eval(/ 1 /)
    }

    def "tail"() {
        expect:
        eval(/ (tail [1 2 3]) /) == eval(/ [2 3] /)
    }

    def "map"() {
        expect:
        eval(/ (map (function [:x] { (+ x 1) }) [1 2 3]) /) == eval(/ [2 3 4] /)
    }
}
