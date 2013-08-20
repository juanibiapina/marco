import helpers.IntegrationSpecification

class Strings extends IntegrationSpecification{
    def "strings return themselves"() {
        when:
        def result = eval(/"string literal"/)

        then:
        result.name == "String"
        result.value.value == "string literal"
    }

    def "valid characters inside strings"() {
        expect:
        eval(/"simple string"/).value.value == /simple string/
        eval(/"$%!*() haha _ - + = ^ `\\##|{)"/).value.value == /$%!*() haha _ - + = ^ `\\##|{)/
        eval(/"\\""/).value.value == /\\"/
    }
}
