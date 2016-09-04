package tests.marco.lang.functions.modules

import helpers.MarcoSpecification

class require_native extends MarcoSpecification {
    def "requires a native module"() {
        expect:
        eval(/ (require-native "io") /)
    }
}
