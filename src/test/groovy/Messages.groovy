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
        MarcoObject context = new MarcoObject(runtime);
        MarcoObject expectedResult = new MarcoObject(runtime);
        context.setSlot("aSlot", expectedResult);
        MarcoObject program = message("aSlot");

        when:
        MarcoObject result = runtime.interpreter.eval(context, program);

        then:
        result == expectedResult
    }

    def "sequence of symbol lookups"() {
        given:
        MarcoObject context = new MarcoObject(runtime);
        MarcoObject firstValue = new MarcoObject(runtime);
        context.setSlot("firstValue", firstValue);
        MarcoObject secondValue = new MarcoObject(runtime);
        firstValue.setSlot("secondValue", secondValue);
        MarcoObject thirdValue = new MarcoObject(runtime);
        secondValue.setSlot("thirdValue", thirdValue);

        MarcoObject program = message("firstValue secondValue thirdValue");

        when:
        MarcoObject result = runtime.interpreter.eval(context, program);

        then:
        result == thirdValue
    }
}