package tests.marco.modules.string

import helpers.MarcoSpecification

class concat extends MarcoSpecification {
    def "concat: strings"() {
        given:
        eval(/ (def :string (require "string")) /)

        expect:
        eval(/ (string.concat ["a" "b"]) /) == eval(/ "ab" /)
    }

    def "concat: string with integer"() {
        given:
        eval(/ (def :string (require "string")) /)

        expect:
        eval(/ (string.concat ["a" 1]) /) == eval(/ "a1" /)
    }

    def "concat: several types"() {
        given:
        eval(/ (def :string (require "string")) /)

        expect:
        eval(/ (string.concat [true nil 12 "lol"]) /) == eval(/ "truenil12lol" /)
    }
}
