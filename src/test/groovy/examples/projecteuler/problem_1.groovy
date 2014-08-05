package examples.projecteuler
import helpers.MarcoExampleSpecification
import spock.lang.Ignore

class problem_1 extends MarcoExampleSpecification {
    def "example case"() {
        expect:
        example("projecteuler/problem-1", "10") == "23"
    }

    @Ignore
    def "solution"() {
        expect:
        example("projecteuler/problem-1", "1000") == "?"
    }
}
