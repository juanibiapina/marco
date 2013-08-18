import marco.MarcoException

class Message extends IntegrationSpecification {
    def "sending a message fails when slot does not exist"() {
        when:
        eval("simplemessage")

        then:
        MarcoException e = thrown()
        assert e.getMessage() == "Exception: Global does not respond to simplemessage"
    }
}  