

import helpers.MarcoSpecification

class Objects extends MarcoSpecification {
    def "slot_names"() {
        when:
        def result = eval "slot_names to_string"

        then:
        result.value.value.contains("slot_names")
        result.value.value.contains("clone")
        result.value.value.contains("to_string")
    }
}
