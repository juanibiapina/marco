import helpers.MarcoSpecification

class Number extends MarcoSpecification {
    def "integers return themselves"() {
        when:
        def result = eval "1"

        then:
        result.name == "Number"
        result.value.value == 1
    }

    def "to_string"() {
        when:
        def result = eval "1 to_string"

        then:
        result.value.value == "1"
    }
}
