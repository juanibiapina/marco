(def :io (require "io"))
(def :integer (require "integer"))

(def :make-fib (function [] {
  (def :helper (function [:a :b] {
    (pair a  (function [] { (helper b (+ a b)) }))
  }))

  (helper 1 1)
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

(def :sum (function [:list] {
  (if (nil? list) { 0 }
    { (+ (head list) (recurse (tail list))) })
}))

(def :n (integer.parse (io.read-line io.stdin)))

(def :fib (make-fib))

(def :include? (function [:n] {
  (even? n)
}))

(print (sum (stream-take-while (stream-filter fib include?) (function [:e] { (< e n) }))))
