import helpers.MarcoSpecification

class String extends MarcoSpecification{
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

    def "to_string"() {
        when:
        def result = eval(/"value" to_string/)

        then:
        result.value.value == "value"
    }
}
