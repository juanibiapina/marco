package marco
import helpers.MarcoSpecification

class core extends MarcoSpecification {
    def "map"() {
        expect:
        eval(/ (map (function [:x] { (+ x 1) }) [1 2 3]) /) == eval(/ [2 3 4] /)
    }
}
