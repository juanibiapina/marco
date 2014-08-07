(def :native-integer (require-native "integer"))

(def :parse native-integer.parse)

(def :range (function [:start :end] {
  (def :helper (function [:start :end :acc] {
    (if (< end start) { acc }
      { (recurse start (- end 1) (cons end acc)) })
  }))

  (helper start (- end 1) [])
}))

(export [:parse :range])