import helpers.IntegrationSpecification

class Strings extends IntegrationSpecification{
    def "strings return themselves"() {
        when:
        def result = eval(/"string literal"/)

        then:
        result.name == "String"
        result.value.value == "string literal"
    }
}
