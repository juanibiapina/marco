import helpers.MarcoSpecification
import marco.lang.MarcoBlock

class Blocks extends MarcoSpecification {
    def "brackets are blocks"() {
        expect:
        eval(/ { 1 } /).class == MarcoBlock.class
    }

    def "defining blocks"() {
        given:
        eval(/ (def :b { (+ 1 2) }) /)

        expect:
        eval(/ b /).class == MarcoBlock.class
    }
}
