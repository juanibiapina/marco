(def :io (require "io"))
(def :integer (require "integer"))
(def :stream (require "stream"))

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

(def :n (integer.parse (io.read-line io.stdin)))

(def :primes (stream.filter prime? (stream.integers)))

(def :biggest-factor (function [:n] {
  (def :helper (function [:n :primes] {
    (def :c (stream.head primes))
    (def :t (stream.tail primes))

    (if (= n c) { c }
      {
        (if (divisible n c)
          {
            (def :r (/ n c))
            (if (= r 1) { c }
              { (recurse r primes) })
          }
          {
            (recurse n t)
          }
        )
    })
  }))

  (helper n primes)
}))

(print (biggest-factor n))
