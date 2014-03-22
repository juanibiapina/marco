import helpers.MarcoSpecification
import marco.lang.MarcoNumber

class Comments extends MarcoSpecification {
    def "in the end of the line"() {
        when:
        eval(" (def :x 1 ) // some comment ")

        then:
        eval(" x // more comments ") == new MarcoNumber(1)
    }
}
