package helpers
import marco.internal.Environment
import marco.lang.MarcoObject
import marco.parser.Parser
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoSpecification extends Specification {
    def environment = Environment.initial()
    def parser = Parser.instance()


    def MarcoObject eval(String code) {
        parser.parse(code).eval(environment)
    }

    def classpathFile(content) {
        def file = File.createTempFile("tempFile", ".mrc")
        file.write(content)

        def loader = this.class.classLoader
        loader.addURL(file.parentFile.toURI().toURL())

        file.name
    }
}
