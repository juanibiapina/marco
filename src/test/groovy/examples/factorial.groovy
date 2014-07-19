package examples

import helpers.MarcoExampleSpecification

class factorial extends MarcoExampleSpecification {
    def "factorial of 0"() {
        expect:
        example("factorial", "0") == "1"
    }

    def "factorial of 1"() {
        expect:
        example("factorial", "1") == "1"
    }

    def "factorial of 10"() {
        expect:
        example("factorial", "10") == "3628800"
    }
}
