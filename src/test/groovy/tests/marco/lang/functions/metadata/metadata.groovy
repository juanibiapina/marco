package tests.marco.lang.functions.metadata
import helpers.MarcoSpecification

class metadata extends MarcoSpecification {
    def "adding meta data to a number"() {
        given:
        eval(/ (def :x (with-meta 1 #{:color "blue" :size :small :i 3})) /)

        expect:
        eval(/ ((meta x) :color) /) == eval(/ "blue" /)
        eval(/ ((meta x) :size) /) == eval(/ :small /)
        eval(/ ((meta x) :i) /) == eval(/ 3 /)
    }
}
