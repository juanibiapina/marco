(def :native-io (require-native "io"))

(def :stdin native-io.stdin)
(def :read-line native-io.read-line)

(export [:stdin :read-line])