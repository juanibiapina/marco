import helpers.IntegrationSpecification

class MessageChains extends IntegrationSpecification {
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
}
