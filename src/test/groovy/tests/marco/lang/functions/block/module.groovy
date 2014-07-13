package tests.marco.lang.functions.block
import helpers.MarcoSpecification
import marco.lang.error.ExportError

class module extends MarcoSpecification {
    def "creates a module from a block"() {
        given:
        eval(/ (def :program { (def :b 2) (export :b) }) /)

        when:
        eval(/ (def :m (module program)) /)

        then:
        eval(/ m.b /) == eval(/ 2 /)
    }

    def "hidden members are available to other members"() {
        given:
        eval(/ (def :program { (def :hidden 1) (def :b hidden) (export :b) }) /)

        when:
        eval(/ (def :m (module program)) /)

        then:
        eval(/ m.b /) == eval(/ 1 /)
    }

    def "does not export hidden members"() {
        given:
        eval(/ (def :program { (def :hidden 1) (def :b hidden) (export :b) }) /)

        when:
        eval(/ (def :m (module program)) /)
        eval(/ m.hidden /)

        then:
        ExportError e = thrown()
    }
}
