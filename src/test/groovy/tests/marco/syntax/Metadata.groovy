package tests.marco.syntax
import helpers.MarcoSpecification

class Metadata extends MarcoSpecification {
    def "adding meta data to a number"() {
        given:
        eval(/ (def :x (with-meta 1 #{:color "blue" :size :small :i 3})) /)

        expect:
        eval(/ ((meta x) :color) /) == eval(/ "blue" /)
        eval(/ ((meta x) :size) /) == eval(/ :small /)
        eval(/ ((meta x) :i) /) == eval(/ 3 /)
    }
}
