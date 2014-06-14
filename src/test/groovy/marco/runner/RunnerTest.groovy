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

    def "runs a multi line file"() {
        given:
        def runner = new Runner()

        when:
        runner.run("fixtures/multiline.mrc")

        then:
        runner.runtime.environment.get("v1").value == eval(/ 3 /)
        runner.runtime.environment.get("v2").value == eval(/ 4 /)
    }
}
