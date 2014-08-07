package tests.marco.runtime
import helpers.MarcoSpecification
import marco.lang.error.LookUpError
import marco.runner.Runner

class errors extends MarcoSpecification {
    def "file name"() {
        given:
        def runner = new Runner()
        runner.setThrowExceptions(true)

        when:
        runner.run("fixtures/lookup-error.mrc")

        then:
        LookUpError e = thrown()
        e.fileName == "fixtures/lookup-error.mrc"
    }
}
