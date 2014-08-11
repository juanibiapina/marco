package examples.projecteuler

import helpers.MarcoExampleSpecification
import spock.lang.Ignore

class problem_3 extends MarcoExampleSpecification {
    def "example case"() {
        expect:
        example("projecteuler/problem-3", "13195") == "29"
    }

    @Ignore("slow")
    def "solution"() {
        expect:
        example("projecteuler/problem-3", "600851475143") == "6857"
    }
}
