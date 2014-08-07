package examples

import helpers.MarcoExampleSpecification

class hailstone_longest_size extends MarcoExampleSpecification {
    def "prints the longest sequence up to a 100"() {
        expect:
        example("hailstone-longest-size") == "119"
    }
}
