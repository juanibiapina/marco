import helpers.MarcoSpecification
import marco.lang.MarcoNil
import marco.lang.MarcoNumber
import marco.lang.MarcoPair
import marco.lang.MarcoProgram
import marco.lang.MarcoSymbol

class Parser extends MarcoSpecification {
    def "parsing a simple definition"() {
        given:
        def expected = new MarcoProgram()
        expected.add(new MarcoPair(new MarcoSymbol("def"), new MarcoPair(new MarcoSymbol("x"), new MarcoPair(new MarcoNumber(1), MarcoNil.NIL))))

        expect:
        eval(/ (parse "(def x 1)") /) == expected
    }
}
