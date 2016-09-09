(def :native-string (require-native "string"))

(def :concat native-string.concat)
(def :from native-string.from)
(def :reverse native-string.reverse)

(export [:concat :from :reverse])