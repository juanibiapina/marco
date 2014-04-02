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

    def "using def"() {
        given:
        eval(/ (def :f (function [] { (def :b 1) b })) /)

        expect:
        eval(/ (f) /) == eval(/ 1 /)
    }

    def "using var"() {
        given:
        eval(/ (def :f (function [] { (var :b 1) (set! :b (+ b 1)) b })) /)

        expect:
        eval(/ (f) /) == eval(/ 2 /)
    }

    def "mutating outer bindings"() {
        given:
        eval(/ (var :x 1) /)
        eval(/ (def :f (function [] { (set! :x 3) })) /)

        when:
        eval(/ (f) /)

        then:
        eval(/ x /) == eval(/ 3 /)
    }
}
