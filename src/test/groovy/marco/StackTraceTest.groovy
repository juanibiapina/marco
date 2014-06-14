package marco

import helpers.MarcoSpecification
import marco.internal.StackTrace
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

    def "saves line numbers for each frame"() {
        given:
        def runner = new Runner()

        when:
        runner.run("fixtures/stack-trace.mrc")

        then:
        LookUpError e = thrown()
        StackTrace stackTrace = e.marcoStackTrace
        stackTrace.collect() { it.line } == [3, 5, 7]
    }
}
