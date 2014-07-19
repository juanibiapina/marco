package examples

import helpers.MarcoExampleSpecification

class hailstone extends MarcoExampleSpecification {
    def "prints the hailstone sequence"() {
        expect:
        example("hailstone") == "(6, (3, (10, (5, (16, (8, (4, (2, (1, nil)))))))))"
    }
}
