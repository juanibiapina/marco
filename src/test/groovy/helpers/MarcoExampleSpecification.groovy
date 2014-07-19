package helpers

import marco.runner.Runner
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoExampleSpecification extends Specification {
    def originalOut = System.out
    def originalIn = System.in

    def restoreChannels() {
        System.in = originalIn
        System.out = originalOut
    }

    def example(name, input = "") {
        def buf = new ByteArrayOutputStream()
        def newOut = new PrintStream(buf)
        System.out = newOut

        System.in = new ByteArrayInputStream((input + "\r\n").bytes)

        def runner = new Runner()

        def fileName = "examples/" + name + ".mrc"
        runner.run(fileName)

        restoreChannels()

        buf.toString().trim()
    }
}
