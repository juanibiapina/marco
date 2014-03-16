import helpers.MarcoSpecification

class Data extends MarcoSpecification {
    def "containing one number"() {
        given:
        eval(/ (def number (data (value))) /)

        when:
        eval(/ (def n1 (number 1)) /)

        then:
        eval(/ n1.value /) == eval(/ 1 /)
    }

    def "containing more data"() {
        given:
        eval(/ (def lots_of_data (data (value1 value2 value3 value4))) /)

        when:
        eval(/ (def x 42) /)
        eval(/ (def ll (lots_of_data "string value" [1 2] (function () true) x)) /)

        then:
        eval(/ ll.value1 /) == eval(/ "string value" /)
        eval(/ ll.value2 /) == eval(/ [1 2] /)
        eval(/ (ll.value3) /) == eval(/ true /)
        eval(/ ll.value4 /) == eval(/ 42 /)
    }

    def "nested"() {
        given:
        eval(/ (def data1 (data (value))) /)

        when:
        eval(/ (def d (data1 (data1 "inner value"))) /)

        then:
        eval(/ d.value.value /) == eval(/ "inner value" /)
    }
}
