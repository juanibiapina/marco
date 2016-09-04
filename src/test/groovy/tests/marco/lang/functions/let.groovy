package tests.marco.lang.functions

import helpers.MarcoSpecification

class let extends MarcoSpecification {
    def "value let"() {
        expect:
        eval(/ (let [:a { 1 }] { a }) /) == eval(/ 1 /)
    }

    def "let in expression"() {
        expect:
        eval(/ (let [:a { (+ 1 2) }] { (+ a 2) }) /) == eval(/ 5 /)
    }

    def "function using let"() {
        when:
        eval(/ (def :f (function [:x] { (let [:a { x }] { a }) })) /)

        then:
        eval(/ (f 3) /) == eval(/ 3 /)
    }

    def "passing a literal list"() {
        when:
        eval(/ (def :f (function [:x] { (let [:a { x }] { (head a) }) })) /)

        then:
        eval(/ (f [1 2 3]) /) == eval(/ 1 /)
    }

    def "with recursion"() {
        expect:
        eval(/ (let [:a { (function [:x] { (if (= x 0) {0} {(recurse (- x 1))} ) }) }] { (a 3) }) /) == eval(/ 0 /)
    }

    def "accessing the let variable inside the function"() {
        expect:
        eval(/ (let [:a { (function [:x] { (if (= x 0) {0} {(a (- x 1))} ) }) }] { (a 3) }) /) == eval(/ 0 /)
    }
}
