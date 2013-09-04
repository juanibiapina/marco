import helpers.IntegrationSpecification
import marco.MarcoException
import marco.lang.MarcoObject

class Messages extends IntegrationSpecification {
    def "valid characters for messages"() {
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
        def expectedResult = new MarcoObject(runtime)
        context.setSlot "aSlot", expectedResult
        def program = message "aSlot"

        when:
        def result = runtime.interpreter.eval(context, program)

        then:
        result == expectedResult
    }

    def "sequence of symbol lookups"() {
        given:
        def context = new MarcoObject(runtime)
        def firstValue = new MarcoObject(runtime)
        context.setSlot("firstValue", firstValue)
        def secondValue = new MarcoObject(runtime)
        firstValue.setSlot("secondValue", secondValue)
        def thirdValue = new MarcoObject(runtime)
        secondValue.setSlot("thirdValue", thirdValue);

        def program = message("firstValue secondValue thirdValue")

        when:
        def result = runtime.interpreter.eval(context, program);

        then:
        result == thirdValue
    }
}