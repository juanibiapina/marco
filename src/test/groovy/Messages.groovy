import helpers.MarcoSpecification
import marco.MarcoException
import marco.lang.MarcoObject

class Messages extends MarcoSpecification {
    def "valid characters"() {
        expect:
        message("abcdef")
        message("abc_abc")
        message("abc-Abc")
        message("AZCVA")
        message("abcABZ")
        message("ABCXaasdjg")
        message("-_fsfFLKJ_-")
    }

    def "sending a message fails when slot does not exist"() {
        when:
        eval("message")

        then:
        MarcoException e = thrown()
        assert e.getMessage() == "Exception: Object does not respond to message"
    }

    def  "simple symbol lookup"() {
        given:
        def context = new MarcoObject(runtime)
        def expected = new MarcoObject(runtime)
        context.setSlot "a_slot", expected
        def program = parse "a_slot"

        when:
        def result = runtime.interpreter.eval(context, program)

        then:
        result == expected
    }

    def "sequence of symbol lookups"() {
        given:
        def context = new MarcoObject(runtime)
        def firstValue = new MarcoObject(runtime)
        context.setSlot("first_value", firstValue)
        def secondValue = new MarcoObject(runtime)
        firstValue.setSlot("second_value", secondValue)
        def thirdValue = new MarcoObject(runtime)
        secondValue.setSlot("third_value", thirdValue);

        def program = parse("first_value second_value third_value")

        when:
        def result = runtime.interpreter.eval(context, program);

        then:
        result == thirdValue
    }

    def "can be chained"() {
        when:
        def result = eval(/"ha" to_string/)

        then:
        result.value.value == "ha"
    }

    def "can be chained further"() {
        when:
        def result = eval(/"haha" "lol" to_string/)

        then:
        result.value.value == "lol"
    }
}