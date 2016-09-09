(def :native-string (require-native "string"))

(def :concat native-string.concat)
(def :from native-string.from)

(export [:concat :from])