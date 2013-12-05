package helpers

import marco.internal.Environment
import marco.lang.MarcoObject
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoSpecification extends Specification {
    def environment = Environment.initial()

    def MarcoObject eval(String code) {
        environment.eval(code)
    }

    def MarcoObject lookUp(String var) {
        environment.lookUp(var)
    }
}
