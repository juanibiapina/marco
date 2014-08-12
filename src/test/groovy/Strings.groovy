import helpers.MarcoSpecification
import marco.lang.MarcoString

class Strings extends MarcoSpecification {
    def "return themselves"() {
        expect:
        eval(/ "some string" /) == new MarcoString("some string")
    }

    def "string representation"() {
        expect:
        new MarcoString("value").toString() == "value"
    }

    def "concat: strings"() {
        expect:
        eval(/ (string-concat ["a" "b"]) /) == eval(/ "ab" /)
    }

    def "concat: string with integer"() {
        expect:
        eval(/ (string-concat ["a" 1]) /) == eval(/ "a1" /)
    }

    def "concat: several types"() {
        expect:
        eval(/ (string-concat [true nil 12 "lol"]) /) == eval(/ "truenil12lol" /)
    }
}
