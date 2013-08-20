import helpers.IntegrationSpecification

class Numbers extends IntegrationSpecification {
    def "integers return themselves"() {
        when:
        def result = eval "1"

        then:
        result.name == "Number"
        result.value.value == 1
    }
}
