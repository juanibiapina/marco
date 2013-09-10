import helpers.MarcoSpecification

class MessageChains extends MarcoSpecification {
    def "messages can be chained"() {
        when:
        def result = eval(/"ha" to_string/)

        then:
        result.value.value == "ha"
    }

    def "messages can be chained further"() {
        when:
        def result = eval(/"haha" "lol" to_string/)

        then:
        result.value.value == "lol"
    }

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
