(def :io (require "io"))
(def :integer (require "integer"))

(def :n (integer.parse (io.read-line io.stdin)))

(def :divisible (function [:n :d] {
  (= (% n d) 0)
}))

(def :prime? (function [:n] {
  (if (= n 1) { false } {
    (if (= n 2) { true } {
      (def :numbers-to-test (integer.range 2 (+ (/ n 2) 1)))

      (not (any numbers-to-test (function [:e] {
        (divisible n e)
      })))
    })
  })
}))

(print (prime? n))
