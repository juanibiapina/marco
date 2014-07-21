package tests.marco.lang.functions.module

import helpers.MarcoSpecification

class include extends MarcoSpecification {
    def "defines all exported symbols from a module"() {
        given:
        def module = classpathModule(/ (def :from-module1 42) (def :from-module2 19) (export [:from-module1 :from-module2]) /)

        when:
        eval(/ (include "${module}") /)

        then:
        eval(/ from-module1 /) == eval(/ 42 /)
        eval(/ from-module2 /) == eval(/ 19 /)
    }
}
