import helpers.MarcoSpecification

class Macros extends MarcoSpecification {
    def "string representation"() {
        expect:
        eval(/ def /).toString() == "Macro"
    }
}
