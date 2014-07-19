package examples

import helpers.MarcoExampleSpecification

class searching_101 extends MarcoExampleSpecification {
    def "number is found"() {
        expect:
        example("searching-101", "10\n10\n10\n10\n10\n10") == "The number 10 appears in the first 5 numbers."
    }

    def "number is not found"() {
        expect:
        example("searching-101", "10\n10\n10\n10\n10\n15") == "The number 15 doesn't appear in the first 5 numbers."
    }
}