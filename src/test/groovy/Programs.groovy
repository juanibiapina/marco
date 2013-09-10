import helpers.MarcoSpecification

class Programs extends MarcoSpecification {
    def "two chains separated by newline"() {
        when:
        def result = eval """1 to_string
2 to_string
"""

        then:
        result.value.value == "2"
    }

    def "chains with several newlines"() {
        when:
        def result = eval """
1 to_string

2 to_string


3 to_string
"""

        then:
        result.value.value == "3"
    }
}
