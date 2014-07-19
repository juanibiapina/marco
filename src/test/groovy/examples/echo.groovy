package examples

import helpers.MarcoExampleSpecification

class echo extends MarcoExampleSpecification {
    def "echoes a line from stdin to stdout"() {
        expect:
        example("echo", "line") == "line"
    }
}
