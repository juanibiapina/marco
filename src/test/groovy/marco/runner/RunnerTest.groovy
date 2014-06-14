package marco.runner

import helpers.MarcoSpecification

class RunnerTest extends MarcoSpecification {
    def "runs a file"() {
        given:
        def runner = new Runner()

        when:
        runner.run("fixtures/simple.mrc")

        then:
        runner.runtime.environment.get("simple").value == eval(/ 3 /)
    }
}
