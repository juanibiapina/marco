package marco

import helpers.MarcoSpecification
import marco.runtime.StackTrace
import marco.lang.error.LookUpError
import marco.runner.Runner

class StackTraceTest extends MarcoSpecification {
    def "build the stack trace messages"() {
        given:
        def runner = new Runner()
        runner.setDebugMode(true)

        when:
        runner.run("fixtures/stack-trace.mrc")

        then:
        LookUpError e = thrown()
        StackTrace stackTrace = e.marcoStackTrace
        stackTrace.buildMessage() == """|    from fixtures/stack-trace.mrc:3
        |    from fixtures/stack-trace.mrc:5
        |    from fixtures/stack-trace.mrc:7
        |""".stripMargin()
    }
}
