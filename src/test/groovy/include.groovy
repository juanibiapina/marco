import helpers.MarcoSpecification

class include extends MarcoSpecification {
    def "includes a file from the classpath"() {
        given:
        def fileName = classpathFile(/ (def from_file 42) /)

        when:
        eval(/ (include "${fileName.replaceFirst(~/\.[^\.]+$/, '')}") /)

        then:
        eval(/ from_file /) == eval(/ 42 /)
    }
}
