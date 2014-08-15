(def :io (require "io"))
(def :integer (require "integer"))

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

(def :stream-integers (function [] {
  (def :helper (function [:n] {
    (pair n (function [] { (helper (+ n 1)) }))
  }))

  (helper 1)
}))

(def :stream-head (function [:stream] {
  (first stream)
}))

(def :stream-tail (function [:stream] {
  ((second stream))
}))

(def :stream-filter (function [:stream :predicate] {
  (def :x (stream-head stream))
  (def :t (stream-tail stream))

  (def :this recurse)

  (if (predicate x)
    { (pair x (function [] { (this t predicate) })) }
    { (recurse t predicate) })
}))

(def :stream-take (function [:n :stream] {
  (if (<= n 0) { nil }
    { (cons (stream-head stream) (recurse (- n 1) (stream-tail stream))) })
}))

(def :stream-take-while (function [:stream :predicate] {
  (def :take? (predicate (stream-head stream)))

  (if take? { (cons (stream-head stream) (recurse (stream-tail stream) predicate)) }
    { nil })
}))

(def :n (integer.parse (io.read-line io.stdin)))

(def :primes (stream-filter (stream-integers) prime?))

(def :biggest-factor (function [:n] {
  (def :helper (function [:n :primes] {
    (def :c (stream-head primes))
    (def :t (stream-tail primes))

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
