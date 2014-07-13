package tests.marco.lang.functions.module

import helpers.MarcoSpecification
import org.junit.Ignore

@Ignore
class require extends MarcoSpecification {
    def "requires a file from the classpath"() {
        given:
        def module = classpathModule(/ (def :from_module 42) /)

        when:
        eval(/ (def :name (require "${module}")) /)

        then:
        eval(/ name.from_module /) == eval(/ 42 /)
    }
}
