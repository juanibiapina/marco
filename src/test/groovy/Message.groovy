import marco.MarcoException

class Message extends IntegrationSpecification {
    def "valid characters for messages"() {
        expect:
        message("aaaaaaa")
        message("abcdef")
        message("abc_abc")
        message("abc-abc")
    }

    def "sending a message fails when slot does not exist"() {
        when:
        eval("message")

        then:
        MarcoException e = thrown()
        assert e.getMessage() == "Exception: Global does not respond to message"
    }
}