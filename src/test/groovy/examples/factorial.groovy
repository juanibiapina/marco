package examples

import helpers.MarcoExampleSpecification

class factorial extends MarcoExampleSpecification {
    def "factorial of 10"() {
        expect:
        example("factorial") == "3628800"
    }
}
