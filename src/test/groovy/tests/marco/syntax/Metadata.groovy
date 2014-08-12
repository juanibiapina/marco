package tests.marco.syntax

import helpers.MarcoSpecification
import spock.lang.Ignore

@Ignore
class Metadata extends MarcoSpecification {
    def "adding meta data field"() {
        given:
        eval(/ (def :x ^#{:color "blue" :size :small :i 3} 1) /)

        expect:
        eval(/ ((meta x) :color) /) == eval(/ "blue" /)
        eval(/ ((meta x) :size) /) == eval(/ :small /)
        eval(/ ((meta x) :i) /) == eval(/ 3 /)
    }
}
