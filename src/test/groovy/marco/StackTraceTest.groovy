package marco

import helpers.MarcoSpecification
import marco.lang.error.LookUpError
import marco.runner.Runner

class StackTraceTest extends MarcoSpecification {
    def "saves line number for the error"() {
        given:
        def runner = new Runner()

        when:
        runner.run("fixtures/stack-trace.mrc")

        then:
        LookUpError e = thrown()
        e.line == 1
    }
}
