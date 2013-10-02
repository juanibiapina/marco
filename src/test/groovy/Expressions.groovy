import helpers.MarcoSpecification

class Expressions extends MarcoSpecification {
    def "ending in newline"() {
        when:
        def result = eval """1 to_string
"""

        then:
        result.value.value == "1"
    }

    def "with a newline separator"() {
        when:
        def result = eval """1 to_string
2 to_string
"""

        then:
        result.value.value == "2"
    }

    def "with several newlines"() {
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
