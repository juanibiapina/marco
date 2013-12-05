package helpers

import marco.internal.Environment
import marco.lang.MarcoObject
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoSpecification extends Specification {
    def environment = Environment.initial()

    def MarcoObject eval(String code) {
        environment.parse(code).eval(environment)
    }

    def MarcoObject lookUp(String var) {
        environment.lookUp(var)
    }
}
