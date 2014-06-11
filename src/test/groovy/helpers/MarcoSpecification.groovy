package helpers

import marco.lang.MarcoObject
import marco.runtime.MarcoRuntime
import org.junit.Ignore
import spock.lang.Specification

@Ignore
abstract class MarcoSpecification extends Specification {
    def runtime = new MarcoRuntime()

    def MarcoObject eval(String code) {
        runtime.run(code)
    }

    def classpathFile(content) {
        def file = File.createTempFile("tempFile", ".mrc")
        file.write(content)

        def loader = this.class.classLoader
        loader.addURL(file.parentFile.toURI().toURL())

        file.name
    }
}
