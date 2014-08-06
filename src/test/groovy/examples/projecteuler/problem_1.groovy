package examples.projecteuler
import helpers.MarcoExampleSpecification

class problem_1 extends MarcoExampleSpecification {
    def "example case"() {
        expect:
        example("projecteuler/problem-1", "10") == "23"
    }

    def "solution"() {
        expect:
        example("projecteuler/problem-1", "1000") == "233168"
    }
}
