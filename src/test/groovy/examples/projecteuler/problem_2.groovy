package examples.projecteuler

import helpers.MarcoExampleSpecification

class problem_2 extends MarcoExampleSpecification {
    def "example case"() {
        expect:
        example("projecteuler/problem-2", "100") == "44"
    }

    def "solution"() {
        expect:
        example("projecteuler/problem-2", "4000000") == "4613732"
    }
}