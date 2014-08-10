package examples

import helpers.MarcoExampleSpecification

class prime extends MarcoExampleSpecification {
    def "1 is not prime"() {
        expect:
        example("prime", "1") == "false"
    }

    def "2 is prime"() {
        expect:
        example("prime", "2") == "true"
    }

    def "3 is prime"() {
        expect:
        example("prime", "3") == "true"
    }

    def "4 is not prime"() {
        expect:
        example("prime", "4") == "false"
    }

    def "23 is prime"() {
        expect:
        example("prime", "23") == "true"
    }
}
