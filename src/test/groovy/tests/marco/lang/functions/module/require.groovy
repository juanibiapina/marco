package tests.marco.lang.functions.module
import helpers.MarcoSpecification

class require extends MarcoSpecification {
    def "requires a file from the classpath"() {
        given:
        def module = classpathModule(/ (def :from_module 42) (export :from_module) /)

        when:
        eval(/ (def :name (require "${module}")) /)

        then:
        eval(/ name.from_module /) == eval(/ 42 /)
    }
}
