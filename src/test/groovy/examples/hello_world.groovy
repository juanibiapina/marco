package examples

import helpers.MarcoExampleSpecification

class hello_world extends MarcoExampleSpecification {
    def "prints hello world to stdout"() {
        expect:
        example("hello-world") == "Hello World\n"
    }
}
