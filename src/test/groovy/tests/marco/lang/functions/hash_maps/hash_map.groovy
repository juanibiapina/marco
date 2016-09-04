package tests.marco.lang.functions.hash_maps

import helpers.MarcoSpecification

class hash_map extends MarcoSpecification {
    def "one element"() {
        given:
        eval(/ (def :h (hash-map [:a 1])) /)

        expect:
        eval(/ (h :a) /) == eval(/ 1 /)
    }

    def "several elements"() {
        given:
        eval(/ (def :h (hash-map [:a 1 :b 2 :c 3])) /)

        expect:
        eval(/ (h :a) /) == eval(/ 1 /)
        eval(/ (h :b) /) == eval(/ 2 /)
        eval(/ (h :c) /) == eval(/ 3 /)
    }
}
