(def :native (require "native"))

(def :stdin native.stdin)
(def :read-line native.read-line)

(export [:stdin :read-line])