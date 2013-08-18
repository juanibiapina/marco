import marco.MarcoException

class Message extends IntegrationSpecification {
    def "sending a message fails when slot does not exist"() {
        when:
        eval("simplemessage")

        then:
        MarcoException e = thrown()
        assert e.getMessage() == "Exception: Global does not respond to simplemessage"
    }

    def "messages can have underscores"() {
        when:
        eval("message_with_underscores")

        then:
        MarcoException e = thrown()
        assert e.getMessage() == "Exception: Global does not respond to message_with_underscores"
    }

    def "messages can have dashes"() {
        when:
        eval("message-with-dashes")

        then:
        MarcoException e = thrown()
        assert e.getMessage() == "Exception: Global does not respond to message-with-dashes"
    }
}  