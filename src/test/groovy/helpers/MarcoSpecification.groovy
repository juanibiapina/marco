package helpers

import marco.interpreter.MarcoInterpreter
import marco.lang.MarcoObject
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoSpecification extends Specification {
    def interpreter = new MarcoInterpreter()

    def MarcoObject eval(String code) {
        interpreter.runLine(code)
    }
}
